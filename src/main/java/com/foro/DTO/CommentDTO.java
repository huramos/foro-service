package com.foro.DTO;

import jakarta.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonFormat;

public class CommentDTO implements Serializable { // ✅ Implementamos Serializable

    private Long id;

    @NotBlank(message = "El contenido del comentario no puede estar vacío") // ✅ Validación obligatoria
    private String content;

    @NotBlank(message = "El nombre de usuario no puede estar vacío") // ✅ Validación obligatoria
    private String username;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") // ✅ Formato estándar para la fecha en JSON
    private LocalDateTime createdAt;

    // 🔹 Constructor vacío
    public CommentDTO() {}

    // 🔹 Constructor con parámetros
    public CommentDTO(Long id, String content, String username, LocalDateTime createdAt) {
        this.id = id;
        this.content = content;
        this.username = username;
        this.createdAt = createdAt;
    }

    // 🔹 Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}