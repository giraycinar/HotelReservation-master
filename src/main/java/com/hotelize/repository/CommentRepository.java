package com.hotelize.repository;

import com.hotelize.domain.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;



public interface CommentRepository extends MongoRepository<Comment, String> {
}
