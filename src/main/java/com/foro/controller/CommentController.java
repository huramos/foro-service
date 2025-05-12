package com.foro.controller;

import com.foro.DTO.CommentDTO;
import com.foro.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {

    private static final Logger logger = LoggerFactory.getLogger(CommentController.class);

    @Autowired
    private CommentService commentService;

    // 🔹 Obtener comentarios por tópico SIN paginación
    @GetMapping("/topic/{topicId}")
    public ResponseEntity<List<CommentDTO>> getCommentsByTopicId(@PathVariable Long topicId) {
        logger.info("📥 Solicitando comentarios para el tópico ID {}", topicId);
        List<CommentDTO> comments = commentService.getCommentsByTopicId(topicId);
        return ResponseEntity.ok(comments);
    }
}