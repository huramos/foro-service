package com.foro.service;

import com.foro.DTO.CommentDTO;
import com.foro.model.Comment;
import com.foro.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CommentService {

    private static final Logger logger = LoggerFactory.getLogger(CommentService.class);

    @Autowired
    private CommentRepository commentRepository;

    // 🔹 Obtiene comentarios por ID de tópico SIN paginación
    public List<CommentDTO> getCommentsByTopicId(Long topicId) {
        if (topicId == null || topicId <= 0) {
            logger.error("❌ Error: ID de tópico inválido.");
            throw new IllegalArgumentException("❌ Error: ID de tópico inválido.");
        }

        List<Comment> comments = commentRepository.findByTopicIdOrderByCreatedAtDesc(topicId);
        return comments.stream()
                .map(comment -> new CommentDTO(
                        comment.getId(),
                        comment.getContent(),
                        comment.getUsername(),
                        comment.getCreatedAt()
                ))
                .collect(Collectors.toList());
    }
}