package com.hotelize.service;

import com.hotelize.domain.Comment;
import com.hotelize.repository.CommentRepository;
import com.hotelize.utils.ServiceManager;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

@Service
public class CommentService extends ServiceManager<Comment, String> {
    private final CommentRepository commentRepository;
    public CommentService(CommentRepository commentRepository) {
        super(commentRepository);
        this.commentRepository = commentRepository;
    }
}
