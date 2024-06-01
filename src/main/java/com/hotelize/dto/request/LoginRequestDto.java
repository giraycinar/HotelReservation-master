package com.hotelize.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginRequestDto {

    @Size(min = 3,max = 64)
    @NotNull
    private String userName;
    @Size(min = 3,max = 32)
    @NotNull
    private String password;
}
