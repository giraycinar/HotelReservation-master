package com.hotelize.controller;

import com.hotelize.domain.Location;
import com.hotelize.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.hotelize.constants.RestApiUrls.*;
import static com.hotelize.constants.RestApiUrls.LOCATION;

@RestController
@RequestMapping(LOCATION)
@RequiredArgsConstructor
public class LocationController {
    private final LocationService locationService;

    @PostMapping(ADD)
    @CrossOrigin("*")
    public ResponseEntity<Location> add(@RequestBody Location location){
        return ResponseEntity.ok(locationService.add(location));
    }
}
