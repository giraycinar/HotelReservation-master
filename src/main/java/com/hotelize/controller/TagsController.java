package com.hotelize.controller;

import com.hotelize.domain.Tags;
import com.hotelize.service.TagsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.hotelize.constants.RestApiUrls.*;
import static com.hotelize.constants.RestApiUrls.TAGS;

@RestController
@RequestMapping(TAGS)
@RequiredArgsConstructor
public class TagsController {
    private final TagsService tagsService;

    @PostMapping(ADD)
    @CrossOrigin("*")
    public ResponseEntity<Tags> add(@RequestBody Tags tags){
        return ResponseEntity.ok(tagsService.add(tags));
    }

}
