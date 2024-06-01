package com.hotelize.service;

import com.hotelize.domain.*;
import com.hotelize.dto.request.HotelAddRequestDto;
import com.hotelize.dto.request.HotelGetFilteredHotelsRequestDto;
import com.hotelize.dto.response.HotelAddResponseDto;
import com.hotelize.exception.hotel_service_exception.ErrorType;
import com.hotelize.exception.hotel_service_exception.HotelServiceException;
import com.hotelize.mapper.HotelMapper;
import com.hotelize.repository.HotelRepository;
import com.hotelize.utils.ServiceManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Slf4j
public class HotelService extends ServiceManager<Hotel,String> {

    private final HotelRepository hotelRepository;
    private final Hotel_TagsService hotelTagsService;
    private final Hotel_TourService hotelTourService;
    Hotel_FeaturesService hotelFeaturesService;
    HotelPromotionService hotelPromotionService;
    Hotel_LocationService hotelLocationService;
    LocationService locationService;
    TagsService tagsService;
    TourService tourService;
    FeaturesService featuresService;


    public HotelService(HotelRepository hotelRepository,
                        Hotel_TagsService hotelTagsService,
                        Hotel_TourService hotelTourService,
                        Hotel_LocationService hotelLocationService,
                        Hotel_FeaturesService hotelFeaturesService,
                        TagsService tagsService,
                        TourService tourService,
                        FeaturesService featuresService,
                        LocationService locationService,
                        HotelPromotionService hotelPromotionService) {
        super(hotelRepository);
        this.hotelRepository = hotelRepository;
        this.hotelTagsService = hotelTagsService;
        this.hotelTourService = hotelTourService;
        this.hotelLocationService = hotelLocationService;
        this.hotelFeaturesService = hotelFeaturesService;
        this.tagsService = tagsService;
        this.tourService = tourService;
        this.featuresService = featuresService;
        this.locationService = locationService;
        this.hotelPromotionService = hotelPromotionService;
    }
    public List<Hotel> findAll(){
        return hotelRepository.findAll();
    }

    public HotelAddResponseDto add(HotelAddRequestDto dto) {

        Hotel hotel = HotelMapper.INSTANCE.fromHotelAddRequestDtoToHotel(dto);
        hotelRepository.save(hotel);

        hotelTagsService.save(Hotel_Tags.builder().hotelId(hotel.getId()).build());
        hotelPromotionService.save(HotelPromotion.builder().hotelId(hotel.getId()).build());
        hotelFeaturesService.save(Hotel_Features.builder().hotelId(hotel.getId()).build());
        hotelTourService.save(Hotel_Tour.builder().hotelId(hotel.getId()).build());
        hotelLocationService.save(Hotel_Location.builder().hotelId(hotel.getId()).build());

        return HotelMapper.INSTANCE.fromHotelToHotelAddResponseDto(hotel);

    }


    public List<Hotel> findAllHotelByIdIn(List<String> ids){
        return hotelRepository.findAllByIdIn(ids);
    }
    public Boolean existsById(String id){
        return hotelRepository.existsById(id);

    }

    public List<Hotel> getFilteredHotels(HotelGetFilteredHotelsRequestDto dto) {

        List<Set<String>> hotelIdsList = new ArrayList<>();

        if(!(dto.getLocationCountry() ==null) || !(dto.getLocationCity() ==null) || !(dto.getLocationAddress() ==null)){
            //LOCATION FILTER
            List<String> hotelIdsByLocationFilter =
                                    hotelLocationService
                                            .findHotelIdsByLocationIds(
                                                    locationService
                                                            .findAllIdsByFilters(
                                                                    dto.getLocationCountry(),
                                                                    dto.getLocationCity(),
                                                                    dto.getLocationAddress()
                                                            ));
            hotelIdsList.add(new HashSet<>(hotelIdsByLocationFilter));

        }
        if(dto.getTagsName()!=null){
            //TAGS FILTER
            List<String> hotelIdsByTagFilter =
                                    hotelTagsService
                                            .findHotelIdsByTagIds(
                                                    tagsService
                                                            .findAllIdsByFilters(
                                                                    dto.getTagsName()
                                                            ));
            hotelIdsList.add(new HashSet<>(hotelIdsByTagFilter));

        }
        if(dto.getFeatureName()!=null||dto.getFeatureIsActive()!=null||dto.getFeatureCount()!=null){
            //FEATURE FILTER
            List<String> hotelIdsByFeatureFilter =
                    hotelFeaturesService
                            .findHotelIdsByFeaturesIds(
                                    featuresService
                                            .findAllIdsByFilters(
                                                    dto.getFeatureName(),
                                                    dto.getFeatureCount(),
                                                    dto.getFeatureIsActive()
                                            ));
            hotelIdsList.add(new HashSet<>(hotelIdsByFeatureFilter));

        }
        if(dto.getTourName()!=null||dto.getTourIsActive()!=null){
            //TOUR FILTER
            List<String> hotelIdsByTourFilter =
                    hotelTourService    // CROSS TABLE SERVICE
                            .findHotelIdsByTourIds(
                                    tourService
                                            .findAllIdsByFilters(
                                                    dto.getTourName(),
                                                    dto.getTourIsActive()
                                            ));
            hotelIdsList.add(new HashSet<>(hotelIdsByTourFilter));
        }

        // Perform set intersection to find common hotel IDs
        Set<String> commonHotelIds = new HashSet<>(hotelIdsList.getFirst());
        for (Set<String> hotelIds : hotelIdsList) {
            commonHotelIds.retainAll(hotelIds); //TODO BURADA YAPILACAK SEYLLER VAR.
        }



        // Retrieve hotels based on common IDs
        List<Hotel> commonHotels = new ArrayList<>();
        for (String hotelId : commonHotelIds) {
            // Retrieve hotel by ID and add it to the list of common hotels
                    commonHotels.add(hotelRepository
                            .findOptionalById(hotelId)
                            .orElseThrow(() -> new HotelServiceException(ErrorType.HOTEL_NOT_FOUND)));

        }

        return commonHotels;

    }

    public Hotel findHotelById(String id) {
        return hotelRepository
                .findOptionalById(id)
                .orElseThrow(() -> new HotelServiceException(ErrorType.HOTEL_NOT_FOUND));
    }
}
