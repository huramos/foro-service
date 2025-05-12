package com.foro.repository;

import com.foro.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository // ✅ Declaramos explícitamente que es un repositorio
public interface CommentRepository extends JpaRepository<Comment, Long> {

    // 🔹 Encuentra comentarios de un tópico SIN paginación, ordenados por fecha descendente
    List<Comment> findByTopicIdOrderByCreatedAtDesc(Long topicId); // ✅ Cambiamos Page<Comment> por List<Comment>
}