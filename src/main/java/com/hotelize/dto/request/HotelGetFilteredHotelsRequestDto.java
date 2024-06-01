package com.hotelize.dto.request;

import com.hotelize.domain.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HotelGetFilteredHotelsRequestDto {
    // filter for Feature.class
    String featureName;
    Integer featureCount;
    Boolean featureIsActive;
    // filter for Location.class
    String locationCountry;
    String locationCity;
    String locationAddress;
    // filter for Tags.class
    String tagsName;
    // filter for Tour.class
    String tourName;
    Boolean tourIsActive;

}
