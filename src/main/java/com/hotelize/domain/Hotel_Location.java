package com.hotelize.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "tbl_hotel_location") // not mentioned by instructor but added as required.
public class Hotel_Location implements Serializable {
    @Id
    private String id;
    private String locationId;
    private String hotelId;
}
