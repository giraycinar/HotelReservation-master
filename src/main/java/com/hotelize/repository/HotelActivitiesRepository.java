package com.hotelize.repository;

import com.hotelize.domain.HotelActivities;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface HotelActivitiesRepository extends MongoRepository<HotelActivities, String> {
}
