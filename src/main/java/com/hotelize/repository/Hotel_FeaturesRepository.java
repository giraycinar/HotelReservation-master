package com.hotelize.repository;

import com.hotelize.domain.Hotel_Features;
import com.hotelize.domain.Hotel_Tags;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface Hotel_FeaturesRepository extends MongoRepository<Hotel_Features, String> {
    List<Hotel_Features> findAllByFeaturesIdIn(List<String> featureIds);

}
