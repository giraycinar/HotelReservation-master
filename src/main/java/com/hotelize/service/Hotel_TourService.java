package com.hotelize.service;


import com.hotelize.domain.Hotel_Tour;
import com.hotelize.repository.Hotel_TourRepository;
import com.hotelize.utils.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class Hotel_TourService extends ServiceManager<Hotel_Tour, String> {
    private final Hotel_TourRepository hotelTourRepository;
    public Hotel_TourService(Hotel_TourRepository hotelTourRepository) {
        super(hotelTourRepository);
        this.hotelTourRepository = hotelTourRepository;
    }

    public List<String> findHotelIdsByTourIds(List<String> tourIds){
        return hotelTourRepository
                .findAllByTourIdIn(tourIds)
                .stream()
                .map(Hotel_Tour::getHotelId)
                .collect(Collectors.toList());
    }
}
