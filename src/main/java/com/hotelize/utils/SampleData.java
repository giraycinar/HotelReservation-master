package com.hotelize.utils;

import com.hotelize.dto.request.AuthRegisterRequestDto;
import com.hotelize.dto.request.CreateUserRequestDto;
import com.hotelize.service.AuthService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.List;

//@Component
public class SampleData {

    AuthService authService;

    @PostConstruct
    public void makeSampleData(){
        AuthRegisterRequestDto instance1 = AuthRegisterRequestDto.builder()
                .userName("user1")
                .password("password1")
                .email("user1@example.com")
                .build();

        AuthRegisterRequestDto instance2 = AuthRegisterRequestDto.builder()
                .userName("user2")
                .password("password2")
                .email("user2@example.com")
                .build();

        AuthRegisterRequestDto instance3 = AuthRegisterRequestDto.builder()
                .userName("user3")
                .password("password3")
                .email("user3@example.com")
                .build();

        AuthRegisterRequestDto instance4 = AuthRegisterRequestDto.builder()
                .userName("user4")
                .password("password4")
                .email("user4@example.com")
                .build();

        AuthRegisterRequestDto instance5 = AuthRegisterRequestDto.builder()
                .userName("user5")
                .password("password5")
                .email("user5@example.com")
                .build();
        authService.register(instance1);
        authService.register(instance2);
        authService.register(instance3);
        authService.register(instance4);
        authService.register(instance5);
        CreateUserRequestDto instance11 = CreateUserRequestDto.builder()
                .authId("1")
                .userName("john_doe")
                .surname("Doe")
                .address("123 Main St")
                .build();

        CreateUserRequestDto instance22 = CreateUserRequestDto.builder()
                .authId("auth")
                .userName("jane_smith")
                .surname("Smith")
                .address("456 Elm St")
                .build();

        CreateUserRequestDto instance33 = CreateUserRequestDto.builder()
                .authId("auth789")
                .userName("alex_jones")
                .surname("Jones")
                .address("789 Oak St")
                .build();

        CreateUserRequestDto instance44 = CreateUserRequestDto.builder()
                .authId("auth012")
                .userName("michael_brown")
                .surname("Brown")
                .address("012 Pine St")
                .build();

        CreateUserRequestDto instance55 = CreateUserRequestDto.builder()
                .authId("auth345")
                .userName("emily_jackson")
                .surname("Jackson")
                .address(null)
                .build();
    }
}
