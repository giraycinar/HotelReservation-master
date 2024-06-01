package com.hotelize.repository;


import com.hotelize.domain.Hotel_Tags;
import com.hotelize.domain.Hotel_Tags;
import com.hotelize.domain.Tags;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface Hotel_TagsRepository extends MongoRepository<Hotel_Tags, String> {


    List<Hotel_Tags> findAllByHotelId(String hotelId);
    List<Hotel_Tags> findAllByTagIdIn(List<String> TagsIds);

}
