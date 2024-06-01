package com.hotelize.dto.request;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateUserRequestDto {

    private String authId; // auth id referansi
    @NotNull
    private String userName;
    @NotNull
    private String surname;
    @Nullable
    private String address;

}
