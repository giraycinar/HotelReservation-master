package com.hotelize.domain;


import com.hotelize.utils.enums.ERole;
import com.hotelize.utils.enums.EStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "tbl_auth") //tbl_auth
public class Auth implements Serializable {
    @Id
    private String id;
    private String userName;
    private String password;
    private String email;
    private String phone;
    private boolean isActive;


    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime updatedAt;


    @Builder.Default
    private ERole role = ERole.USER;

    @Builder.Default
    private EStatus status = EStatus.PENDING;
}
