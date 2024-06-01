package com.hotelize.repository;

import com.hotelize.domain.Auth;
import com.hotelize.utils.enums.ERole;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;


public interface AuthRepository extends MongoRepository<Auth, String> {


    Optional<Auth> findOptionalByUserNameAndPassword(String userName, String password);
    List<Auth> findAllByRole(ERole eRole);

}
