FROM amazoncorretto:21.0.2-alpine3.19
COPY build/libs/HotelReservation.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]