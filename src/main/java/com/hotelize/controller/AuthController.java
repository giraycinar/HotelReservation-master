package com.hotelize.controller;

import com.hotelize.domain.Auth;
import com.hotelize.dto.request.AuthRegisterRequestDto;
import com.hotelize.dto.request.LoginRequestDto;
import com.hotelize.dto.response.AuthRegisterResponseDto;
import com.hotelize.service.AuthService;
import com.hotelize.utils.JwtTokenManager;
import com.hotelize.utils.enums.ERole;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import com.hotelize.exception.auth_exception.*;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static com.hotelize.constants.RestApiUrls.*;
import static com.hotelize.constants.RestApiUrls.AUTH;

@RestController
@RequestMapping(AUTH)
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    private final JwtTokenManager tokenManager;


    @PostMapping(REGISTER)
    @CrossOrigin("*")
    public ResponseEntity<AuthRegisterResponseDto> register(AuthRegisterRequestDto request) {return authService.register(request);
    }

    @PostMapping(LOGIN)
    @CrossOrigin("*")
    public ResponseEntity<String> login(@RequestBody @Valid LoginRequestDto dto){
        Optional<Auth> auth = authService.login(dto);
        if (auth.isEmpty())
            throw new AuthServiceException(ErrorType.ERROR_INVALID_LOGIN_PARAMETER);
        Optional<String> token = tokenManager.createToken(auth.get().getId());
        if (token.isEmpty())
            throw new AuthServiceException(ErrorType.ERROR_CREATE_TOKEN);
        return ResponseEntity.ok(token.get());
    }

    @GetMapping(CREATE_TOKEN)
    @CrossOrigin("*")
    public ResponseEntity<String> createToken(String id, ERole role){
        return ResponseEntity.ok(tokenManager.createToken(id,role));
    }







}
