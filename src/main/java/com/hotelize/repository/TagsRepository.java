package com.hotelize.repository;

import com.hotelize.domain.Location;
import com.hotelize.domain.Tags;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface TagsRepository extends MongoRepository<Tags, String> {
}
