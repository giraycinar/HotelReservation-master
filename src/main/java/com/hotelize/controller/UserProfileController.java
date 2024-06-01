package com.hotelize.controller;

import com.hotelize.domain.Hotel;
import com.hotelize.domain.UserProfile;
import com.hotelize.dto.request.AddFavouriteRequestDto;
import com.hotelize.dto.request.CreateUserRequestDto;
import com.hotelize.dto.request.UserProfileUpdateRequestDto;
import com.hotelize.dto.response.CreateUserResponseDto;
import com.hotelize.service.UserProfileService;
import com.hotelize.utils.JwtTokenManager;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.hotelize.constants.RestApiUrls.USERPROFILE;
import static com.hotelize.constants.RestApiUrls.*;


@RestController
@RequestMapping(USERPROFILE)
@RequiredArgsConstructor
public class UserProfileController {
    private final UserProfileService userProfileService;
    private final JwtTokenManager tokenManager;

    @PostMapping(CREATE)
    @CrossOrigin("*")
    public ResponseEntity<CreateUserResponseDto> createUserProfile(@RequestBody @Valid CreateUserRequestDto dto){
        return ResponseEntity.ok(userProfileService.createUserProfile(dto));

    }

    @PostMapping(FIND_ALL)
    @CrossOrigin("*")
    public ResponseEntity<List<UserProfile>> findAll(){
        return ResponseEntity.ok(userProfileService.findAll());
    }

    @PostMapping(FIND_BY_ID)
    @CrossOrigin("*")
    public ResponseEntity<UserProfile> findById(@RequestParam String id){
        return ResponseEntity.ok(userProfileService.findUserById(id));
    }

    @PostMapping(UPDATE)
    @CrossOrigin("*")
    public ResponseEntity<UserProfile> update(@RequestBody UserProfileUpdateRequestDto dto){
        return ResponseEntity.ok(userProfileService.update(dto));
    }

    @GetMapping(GET_ID_FROM_TOKEN)
    @CrossOrigin("*")
    public ResponseEntity<UserProfile> getIdFromToken(@RequestParam String token){
        return ResponseEntity.ok(userProfileService.findUserByToken(token));
    }

    @PutMapping(ADD_FAVOURITE)
    @CrossOrigin("*")
    public ResponseEntity<Boolean> addFavourite(@RequestBody AddFavouriteRequestDto dto){
        return ResponseEntity.ok(userProfileService.addFavourite(dto));
    }

    @GetMapping(GET_FAVOURITES)
    @CrossOrigin("*")
    public ResponseEntity<List<Hotel>> getFavourites(@RequestParam String token){
        return ResponseEntity.ok(userProfileService.getFavourite(token));
    }


}
