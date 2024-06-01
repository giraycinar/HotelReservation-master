package com.hotelize.repository;

import com.hotelize.domain.HotelPromotion;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface HotelPromotionRepository extends MongoRepository<HotelPromotion, String> {
}
