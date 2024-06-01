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
@Document(collection = "tbl_promotion") // tbl_otel_tanitim
public class HotelPromotion implements Serializable {
    @Id
    private String id;

    private String hotelId; // otel id referansi
    private String title; // baslik
    private String description; // aciklama
}
