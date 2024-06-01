package com.hotelize.controller;

import com.hotelize.domain.Hotel;
import com.hotelize.dto.request.HotelAddRequestDto;
import com.hotelize.dto.request.HotelGetFilteredHotelsRequestDto;
import com.hotelize.dto.response.HotelAddResponseDto;
import com.hotelize.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.hotelize.constants.RestApiUrls.*;
import static com.hotelize.constants.RestApiUrls.HOTEL;

@RestController
@RequestMapping(HOTEL)
@RequiredArgsConstructor
public class HotelController {
    private final HotelService hotelService;

    @GetMapping(FIND_ALL)
    @CrossOrigin("*")
    public ResponseEntity<List<Hotel>> findAll(){
        return ResponseEntity.ok(hotelService.findAll());
    }

    @PostMapping(ADD)
    @CrossOrigin("*")
    public ResponseEntity<HotelAddResponseDto> add(@RequestBody HotelAddRequestDto dto){
        return ResponseEntity.ok(hotelService.add(dto));
    }

    @PostMapping(FIND_BY_ID)
    @CrossOrigin("*")
    public ResponseEntity<Hotel> findById(@RequestParam(name="id") String id){
        return ResponseEntity.ok(hotelService.findHotelById(id));
    }


    @PostMapping(GET_FILTERED_HOTELS)
    @CrossOrigin("*")
    public ResponseEntity<List<Hotel>> getFilteredHotels(@RequestBody HotelGetFilteredHotelsRequestDto dto){
        return ResponseEntity.ok(hotelService.getFilteredHotels(dto));
    }


}
