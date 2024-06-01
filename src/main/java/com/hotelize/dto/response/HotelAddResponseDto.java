package com.hotelize.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HotelAddResponseDto {

    String name;
    String location;
    Double longitude;
    Double latitude;
    Integer totalPoint;
    String checkInTime;
    String checkOutTime;
    String description;
}
