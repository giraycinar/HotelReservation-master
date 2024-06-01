package com.hotelize.service;

import com.hotelize.domain.Auth;
import com.hotelize.dto.request.AuthRegisterRequestDto;
import com.hotelize.dto.request.LoginRequestDto;
import com.hotelize.dto.response.AuthRegisterResponseDto;
import com.hotelize.exception.auth_exception.ErrorType;
import com.hotelize.exception.auth_exception.AuthManagerException;
import com.hotelize.repository.AuthRepository;
import com.hotelize.utils.JwtTokenManager;
import com.hotelize.utils.ServiceManager;
import com.hotelize.utils.enums.EStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService extends ServiceManager<Auth, String> {
    private final AuthRepository authRepository;
    private final JwtTokenManager jwtTokenManager;
    ErrorType authErrorType;


    public AuthService(AuthRepository authRepository, UserProfileService userProfileService, JwtTokenManager jwtTokenManager) {
        super(authRepository);

        this.authRepository = authRepository;
        this.jwtTokenManager = jwtTokenManager;

    }

    public ResponseEntity<AuthRegisterResponseDto> register(AuthRegisterRequestDto request) {
        Auth auth = Auth.builder()
                .userName(request.getUserName())
                .password(request.getPassword())
                .email(request.getEmail())
                .isActive(true)
                .build();
        authRepository.save(auth);
        AuthRegisterResponseDto response = AuthRegisterResponseDto.builder()
                .userName(request.getUserName())
                .email(request.getEmail())
                .build();
        return ResponseEntity.ok(response);
    }


    public Optional<Auth> login(LoginRequestDto dto){
        Optional<Auth> auth = authRepository.findOptionalByUserNameAndPassword(dto.getUserName(),dto.getPassword());
        return auth;
    }



//    public String login(LoginRequestDto dto) {
//        Optional<Auth> authOptional = authRepository.findOptionalByUserNameAndPassword(dto.getUserName(),dto.getPassword());
//        if(authOptional.isEmpty()){
//            throw new AuthManagerException(ErrorType.LOGIN_ERROR);
//        }
//        if(authOptional.get().getStatus().equals(EStatus.ACTIVE)){
//            return jwtTokenManager.createToken(authOptional.get().getId(),authOptional.get().getRole())
//                    .orElseThrow(() -> { throw new AuthManagerException(ErrorType.TOKEN_NOT_CREATED);});
//        } else {
//            throw new AuthManagerException(ErrorType.ACCOUNT_NOT_ACTIVE);
//        }
//    }





}
