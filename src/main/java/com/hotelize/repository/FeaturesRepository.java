package com.hotelize.repository;

import com.hotelize.domain.Features;
import com.hotelize.domain.Tour;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface FeaturesRepository extends MongoRepository<Features, String> {
}
