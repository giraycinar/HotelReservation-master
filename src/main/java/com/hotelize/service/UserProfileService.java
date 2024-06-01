package com.hotelize.service;

import com.hotelize.domain.Hotel;
import com.hotelize.domain.UserProfile;
import com.hotelize.dto.request.AddFavouriteRequestDto;
import com.hotelize.dto.request.CreateUserRequestDto;
import com.hotelize.dto.request.UserProfileUpdateRequestDto;
import com.hotelize.dto.response.CreateUserResponseDto;
import com.hotelize.exception.auth_exception.AuthServiceException;
import com.hotelize.exception.hotel_service_exception.HotelServiceException;
import com.hotelize.exception.user_profile_service_exception.ErrorType;
import com.hotelize.exception.user_profile_service_exception.UserProfileServiceException;
import com.hotelize.mapper.UserProfileMapper;
import com.hotelize.repository.UserProfileRepository;
import com.hotelize.utils.JwtTokenManager;
import com.hotelize.utils.ServiceManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserProfileService extends ServiceManager<UserProfile, String> {

    private final UserProfileRepository userProfileRepository;
    AuthService authService;
    HotelService hotelService;
    private final JwtTokenManager jwtTokenManager;


    public UserProfileService(UserProfileRepository userProfileRepository,JwtTokenManager jwtTokenManager) {
        super(userProfileRepository);
        this.userProfileRepository = userProfileRepository;
        this.jwtTokenManager = jwtTokenManager;
    }



    public CreateUserResponseDto createUserProfile(CreateUserRequestDto dto){

        authService.findById(dto.getAuthId())
                .orElseThrow(() -> new AuthServiceException(com.hotelize.exception.auth_exception.ErrorType.AUTH_ID_NOT_FOUND));


        UserProfile userProfile = UserProfileMapper.INSTANCE.fromCreateRequestToUserProfile(dto);
        save(userProfile);

        return UserProfileMapper.INSTANCE.fromUserProfileToCreateResponseDto(userProfile);
    }

    public UserProfile findUserById(String id){
        return userProfileRepository.findById(id).orElseThrow(() -> new UserProfileServiceException(ErrorType.ERROR_USER_NOT_FOUND));
    }

    public UserProfile findUserByToken(String token) {
        return userProfileRepository
                .findOptionalByAuthId(jwtTokenManager.getIdFromToken(token)
                        .orElseThrow(() -> new UserProfileServiceException(ErrorType.ERROR_FIND_ID_BY_TOKEN)))
                .orElseThrow(() -> new UserProfileServiceException(ErrorType.ERROR_USER_NOT_FOUND));
    }
    public UserProfile update(UserProfileUpdateRequestDto dto) {

        UserProfile userProfile = findUserByToken(dto.getToken());

        userProfile.setName(dto.getNewName()); // yeni verilen isim set ediliyor. // TODO EGER VERILMEDIYSE KULLANILAMAYACAK
        userProfile.setSurname(dto.getNewSurname()); // yeni verilen soyisim set ediliyor.
        userProfile.setAddress(dto.getNewAddress()); // yeni verilen adres set ediliyor.
        return userProfileRepository.save(userProfile);
    }


    public List<Hotel> getFavourite(String token) {
        UserProfile userProfile = findUserByToken(token);

        return hotelService.findAllHotelByIdIn(userProfile.getLikedHotelsId());
    }

    public Boolean addFavourite(AddFavouriteRequestDto dto) {
        UserProfile userProfile = findUserByToken(dto.getToken());
        if(hotelService.existsById(dto.getHotelId()))
        userProfile.getLikedHotelsId().add(dto.getHotelId());
        else{
            throw new HotelServiceException(com.hotelize.exception.hotel_service_exception.ErrorType.HOTEL_NOT_FOUND);
        }
        userProfileRepository.save(userProfile);
        return true;
    }


}
