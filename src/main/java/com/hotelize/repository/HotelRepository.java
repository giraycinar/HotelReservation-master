package com.hotelize.repository;

import com.hotelize.domain.Hotel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface HotelRepository extends MongoRepository<Hotel, String> {

//    List<Hotel> findTop10();
    List<Hotel> findAllByIdIn(List<String> ids);


    List<Hotel> findAllByNameContainingIgnoreCaseOrLocationContainingIgnoreCase(String name, String location);

    Optional<Hotel> findOptionalById(String id);
}
