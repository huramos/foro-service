package com.foro.DTO;

import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.List;

public class TopicDTO {

    private Long id;

    @NotBlank(message = "El título no puede estar vacío")
    private String title;

    @NotBlank(message = "La descripción no puede estar vacía")
    private String description;

    private LocalDateTime createdAt;

    private List<CommentDTO> comments;

    // Constructor vacío
    public TopicDTO() {}

    // Constructor con parámetros
    public TopicDTO(Long id, String title, String description, LocalDateTime createdAt, List<CommentDTO> comments) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.createdAt = createdAt;
        this.comments = comments;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public List<CommentDTO> getComments() {
        return comments;
    }

    public void setComments(List<CommentDTO> comments) {
        this.comments = comments;
    }
}