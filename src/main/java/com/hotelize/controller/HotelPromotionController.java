package com.hotelize.controller;

import com.hotelize.domain.HotelPromotion;
import com.hotelize.service.HotelPromotionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static com.hotelize.constants.RestApiUrls.*;
import static com.hotelize.constants.RestApiUrls.HOTELPROMOTION;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(HOTELPROMOTION)
@RequiredArgsConstructor
public class HotelPromotionController {
    private final HotelPromotionService hotelPromotionService;

    @PostMapping(ADD)
    @CrossOrigin("*")
    public ResponseEntity<HotelPromotion> add(@RequestBody HotelPromotion hotelPromotion){
        return ResponseEntity.ok(hotelPromotionService.add(hotelPromotion));
    }
}
