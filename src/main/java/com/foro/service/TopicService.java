package com.foro.service;

import com.foro.model.Topic;
import com.foro.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

@Service
public class TopicService {

    private static final Logger logger = LoggerFactory.getLogger(TopicService.class);

    @Autowired
    private TopicRepository topicRepository;

    // 🔹 Obtiene todos los tópicos SIN paginación
    public List<Topic> getTopics() {
        logger.info("📥 Solicitando todos los tópicos SIN paginación");
        List<Topic> topics = topicRepository.findAll();
        logger.info("✅ Número de tópicos encontrados: {}", topics.size());
        return topics;
    }
}