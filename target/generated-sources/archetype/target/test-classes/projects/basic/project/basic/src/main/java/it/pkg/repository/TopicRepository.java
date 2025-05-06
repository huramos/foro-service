package it.pkg.repository;

import it.pkg.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic, Long> {
    // Métodos personalizados si los necesitas
}