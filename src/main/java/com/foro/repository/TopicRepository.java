package com.foro.repository;

import com.foro.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository // Indicamos que es un repositorio
public interface TopicRepository extends JpaRepository<Topic, Long> {
    // Al heredar de JpaRepository disponemos de findAll() que retorna List<Topic>
}