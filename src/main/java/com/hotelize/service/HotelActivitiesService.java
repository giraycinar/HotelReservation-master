package com.hotelize.service;

import com.hotelize.domain.HotelActivities;
import com.hotelize.repository.HotelActivitiesRepository;
import com.hotelize.utils.ServiceManager;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

@Service
public class HotelActivitiesService extends ServiceManager<HotelActivities, String> {
    private final HotelActivitiesRepository hotelActivitiesRepository;


    public HotelActivitiesService(HotelActivitiesRepository hotelActivitiesRepository) {
        super(hotelActivitiesRepository);
        this.hotelActivitiesRepository = hotelActivitiesRepository;
    }

    public HotelActivities add(HotelActivities hotelActivities) {

        return hotelActivitiesRepository.save(hotelActivities);
    }
}
