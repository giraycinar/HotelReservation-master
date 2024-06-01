package com.hotelize.repository;

import com.hotelize.domain.Hotel_Location;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Collection;
import java.util.List;

public interface Hotel_LocationRepository extends MongoRepository<Hotel_Location, String> {
    List<Hotel_Location> findAllByLocationIdIn(List<String> locationIds);
}
