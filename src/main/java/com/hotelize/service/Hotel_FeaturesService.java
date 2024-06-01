package com.hotelize.service;

import com.hotelize.domain.Hotel_Features;
import com.hotelize.domain.Hotel_Features;
import com.hotelize.repository.Hotel_FeaturesRepository;
import com.hotelize.utils.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class Hotel_FeaturesService extends ServiceManager<Hotel_Features, String> {

    private final Hotel_FeaturesRepository hotelFeaturesRepository;

    public Hotel_FeaturesService(Hotel_FeaturesRepository hotelFeaturesRepository) {
        super(hotelFeaturesRepository);
        this.hotelFeaturesRepository = hotelFeaturesRepository;
    }
    public List<String> findHotelIdsByFeaturesIds(List<String> featuresIds){
        return hotelFeaturesRepository
                .findAllByFeaturesIdIn(featuresIds)
                .stream()
                .map(Hotel_Features::getHotelId)
                .collect(Collectors.toList());
    }

}
