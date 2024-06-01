package com.hotelize.controller;

import com.hotelize.domain.Tour;
import com.hotelize.service.TourService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static com.hotelize.constants.RestApiUrls.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(TOUR)
@RequiredArgsConstructor
public class TourController {
    private final TourService tourService;

    @PostMapping(ADD)
    @CrossOrigin("*")
    public ResponseEntity<Tour> add(@RequestBody Tour tour){
        return ResponseEntity.ok(tourService.add(tour));
    }
}
