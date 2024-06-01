package com.hotelize.exception.hotel_service_exception;

import lombok.Getter;

@Getter
public class HotelServiceException extends RuntimeException {
    private final ErrorType errorType;
    public HotelServiceException(ErrorType errorType){
        super(errorType.getMessage());
        this.errorType = errorType;
    }

    public HotelServiceException(ErrorType errorType, String message){
        super(message);
        this.errorType = errorType;
    }

}
