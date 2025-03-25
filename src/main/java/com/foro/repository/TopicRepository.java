package com.foro.repository;

import com.foro.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic, Long> {
    // Métodos personalizados si los necesitas
}