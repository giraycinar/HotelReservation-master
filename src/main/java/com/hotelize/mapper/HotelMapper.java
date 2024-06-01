package com.hotelize.mapper;


import com.hotelize.domain.Hotel;
import com.hotelize.dto.request.HotelAddRequestDto;
import com.hotelize.dto.response.HotelAddResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface HotelMapper {
    HotelMapper INSTANCE = Mappers.getMapper(HotelMapper.class);

    Hotel fromHotelAddRequestDtoToHotel(final HotelAddRequestDto dto);
    HotelAddResponseDto fromHotelToHotelAddResponseDto(final Hotel hotel);
}
