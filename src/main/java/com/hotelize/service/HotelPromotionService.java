package com.hotelize.service;

import com.hotelize.domain.HotelPromotion;
import com.hotelize.repository.HotelPromotionRepository;
import com.hotelize.utils.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class HotelPromotionService extends ServiceManager<HotelPromotion, String> {

    private final HotelPromotionRepository hotelPromotionRepository;

    public HotelPromotionService(HotelPromotionRepository hotelPromotionRepository) {
        super(hotelPromotionRepository);
        this.hotelPromotionRepository = hotelPromotionRepository;
    }

    public HotelPromotion add(HotelPromotion hotelPromotion) {

        return hotelPromotionRepository.save(hotelPromotion);
    }
}
