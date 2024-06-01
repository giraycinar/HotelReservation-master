package com.hotelize.controller;

import com.hotelize.domain.HotelActivities;
import com.hotelize.service.HotelActivitiesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.hotelize.constants.RestApiUrls.*;
import static com.hotelize.constants.RestApiUrls.HOTEL_ACTIVITIES;

@RestController
@RequestMapping(HOTEL_ACTIVITIES)
@RequiredArgsConstructor
public class HotelActivitiesController {
    private final HotelActivitiesService hotelActivitiesService;

    @PostMapping(ADD)
    @CrossOrigin("*")
    public ResponseEntity<HotelActivities> add(@RequestBody HotelActivities hotelActivities){
        return ResponseEntity.ok(hotelActivitiesService.add(hotelActivities));
    }
}
