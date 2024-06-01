package com.hotelize.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "tbl_hotel")
public class Hotel implements Serializable {
    @MongoId
    private String id;
    private String name;
    private String location;
    private Double longitude;
    private Double latitude;
    private Integer totalPoint;
    private String checkInTime;
    private String checkOutTime;
    private String description;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Document("tbl_image")
    public static class Images{
        @Id
        private String id;
        private String url;
        private String hotelId; // otel referansi
        private ImageCategory imageCategory;
        @CreatedDate
        private LocalDateTime createdAt;
        @LastModifiedDate
        private LocalDateTime updatedAt;
        @Data
        @NoArgsConstructor
        @AllArgsConstructor
        @Builder
        @Document("tbl_image_category")
        public static class ImageCategory{
            @Id
            private String id;
            private String name;
            @CreatedDate
            private LocalDateTime createdAt;
            @LastModifiedDate
            private LocalDateTime updatedAt;
        }
    }

    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime updatedAt;

}
