package com.hotelize.service;

import com.hotelize.domain.Hotel_Location;
import com.hotelize.repository.Hotel_LocationRepository;
import com.hotelize.utils.ServiceManager;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class Hotel_LocationService extends ServiceManager<Hotel_Location,String> {
    private final Hotel_LocationRepository hotelLocationRepository;
    LocationService locationService;

    public Hotel_LocationService(Hotel_LocationRepository hotelLocationRepository) {
        super(hotelLocationRepository);
        this.hotelLocationRepository = hotelLocationRepository;
    }

    /**
     * This method returns the list of hotel ids that matches with the given location Ids.
     * It will be used to navigate to the related hotels.
     * @param locationIds List of Location Ids
     * @return List of Hotel Ids
     */
    public List<String> findHotelIdsByLocationIds(List<String> locationIds){
        return hotelLocationRepository
                .findAllByLocationIdIn(locationIds)
                .stream()
                .map(Hotel_Location::getHotelId)
                .collect(Collectors.toList());
    }
}
