package com.foro.repository;

import com.foro.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByTopicId(Long topicId); // Encuentra comentarios por ID de tema
}