package com.foro.controller;

import com.foro.DTO.TopicDTO;
import com.foro.model.Topic;
import com.foro.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topics")
public class TopicController {

    @Autowired
    private TopicService topicService;

    @GetMapping
    public List<TopicDTO> getAllTopics() {
        return topicService.getAllTopicsAsDTO();
    }

    @PostMapping
    public Topic createTopic(@RequestBody Topic topic) {
        return topicService.createTopic(topic);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TopicDTO> getTopicById(@PathVariable Long id) {
        TopicDTO topicDTO = topicService.getTopicDTOById(id);
        return ResponseEntity.ok(topicDTO);
    }
}