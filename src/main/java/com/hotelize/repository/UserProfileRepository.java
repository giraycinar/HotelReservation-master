package com.hotelize.repository;

import com.hotelize.domain.UserProfile;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserProfileRepository extends MongoRepository<UserProfile, String> {

    Optional<UserProfile> findOptionalByAuthId(String authId);


}
