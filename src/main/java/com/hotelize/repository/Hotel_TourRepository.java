package com.hotelize.repository;

import com.hotelize.domain.Hotel_Tags;
import com.hotelize.domain.Hotel_Tour;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface Hotel_TourRepository extends MongoRepository<Hotel_Tour, String> {

    List<Hotel_Tour> findAllByTourIdIn(List<String> tourIds);

}
