package com.foro.controller;

import com.foro.model.Topic;
import com.foro.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.List;

@RestController
@RequestMapping("/topics")
public class TopicController {

    @Autowired
    private TopicService topicService;

    // 🔹 Endpoint para obtener todos los tópicos SIN paginación
    @GetMapping
    public ResponseEntity<List<Topic>> getTopics() {
        List<Topic> topics = topicService.getTopics();
        return ResponseEntity.ok(topics);
    }
} 