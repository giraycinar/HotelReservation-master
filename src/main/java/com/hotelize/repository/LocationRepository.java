package com.hotelize.repository;

import com.hotelize.domain.Location;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

public interface LocationRepository extends MongoRepository<Location, String> {




}
