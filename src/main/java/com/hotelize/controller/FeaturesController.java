package com.hotelize.controller;

import com.hotelize.domain.Features;
import com.hotelize.service.FeaturesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.hotelize.constants.RestApiUrls.*;
import static com.hotelize.constants.RestApiUrls.FEATURES;

@RestController
@RequestMapping(FEATURES)
@RequiredArgsConstructor
public class FeaturesController {
    private final FeaturesService featuresService;

    @PostMapping(ADD)
    @CrossOrigin("*")
    public ResponseEntity<Features> add(@RequestBody Features features){
        return ResponseEntity.ok(featuresService.add(features));
    }
}
