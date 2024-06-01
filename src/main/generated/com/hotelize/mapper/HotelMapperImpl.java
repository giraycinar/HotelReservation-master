package com.hotelize.mapper;

import com.hotelize.domain.Hotel;
import com.hotelize.dto.request.HotelAddRequestDto;
import com.hotelize.dto.response.HotelAddResponseDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-15T11:41:44+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21 (Oracle Corporation)"
)
@Component
public class HotelMapperImpl implements HotelMapper {

    @Override
    public Hotel fromHotelAddRequestDtoToHotel(HotelAddRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        Hotel.HotelBuilder hotel = Hotel.builder();

        hotel.name( dto.getName() );
        hotel.location( dto.getLocation() );
        hotel.longitude( dto.getLongitude() );
        hotel.latitude( dto.getLatitude() );
        hotel.totalPoint( dto.getTotalPoint() );
        hotel.checkInTime( dto.getCheckInTime() );
        hotel.checkOutTime( dto.getCheckOutTime() );
        hotel.description( dto.getDescription() );

        return hotel.build();
    }

    @Override
    public HotelAddResponseDto fromHotelToHotelAddResponseDto(Hotel hotel) {
        if ( hotel == null ) {
            return null;
        }

        HotelAddResponseDto.HotelAddResponseDtoBuilder hotelAddResponseDto = HotelAddResponseDto.builder();

        hotelAddResponseDto.name( hotel.getName() );
        hotelAddResponseDto.location( hotel.getLocation() );
        hotelAddResponseDto.longitude( hotel.getLongitude() );
        hotelAddResponseDto.latitude( hotel.getLatitude() );
        hotelAddResponseDto.totalPoint( hotel.getTotalPoint() );
        hotelAddResponseDto.checkInTime( hotel.getCheckInTime() );
        hotelAddResponseDto.checkOutTime( hotel.getCheckOutTime() );
        hotelAddResponseDto.description( hotel.getDescription() );

        return hotelAddResponseDto.build();
    }
}
