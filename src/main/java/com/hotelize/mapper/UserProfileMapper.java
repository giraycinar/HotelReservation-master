package com.hotelize.mapper;

import com.hotelize.dto.request.CreateUserRequestDto;
import com.hotelize.domain.UserProfile;
import com.hotelize.dto.request.CreateUserRequestDto;
import com.hotelize.dto.request.UserProfileUpdateRequestDto;
import com.hotelize.dto.response.CreateUserResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserProfileMapper {

    UserProfileMapper INSTANCE = Mappers.getMapper(UserProfileMapper.class);

    UserProfile fromCreateRequestToUserProfile(final CreateUserRequestDto dto);
    CreateUserResponseDto fromUserProfileToCreateResponseDto(final UserProfile userProfile);

    UserProfile fromUserProfileUpdateRequestDtoToUserProfile(final UserProfileUpdateRequestDto dto);


}
