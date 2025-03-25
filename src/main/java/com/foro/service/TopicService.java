package com.foro.service;

import com.foro.DTO.CommentDTO;
import com.foro.DTO.TopicDTO;
import com.foro.model.Topic;
import com.foro.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    public List<TopicDTO> getAllTopicsAsDTO() {
        return topicRepository.findAll().stream()
            .map(this::mapTopicToDTO)
            .collect(Collectors.toList());
    }

    public Topic createTopic(Topic topic) {
        return topicRepository.save(topic);
    }

    public Topic getTopicById(Long id) {
        return topicRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Tema no encontrado"));
    }

    public TopicDTO getTopicDTOById(Long id) {
        Topic topic = getTopicById(id);
        return mapTopicToDTO(topic);
    }

    private TopicDTO mapTopicToDTO(Topic topic) {
        return new TopicDTO(
            topic.getId(),
            topic.getTitle(),
            topic.getDescription(),
            topic.getCreatedAt(),
            topic.getComments().stream()
                .map(comment -> new CommentDTO(
                    comment.getId(),
                    comment.getContent(),
                    comment.getUsername(),
                    comment.getCreatedAt()
                ))
                .collect(Collectors.toList())
        );
    }
}