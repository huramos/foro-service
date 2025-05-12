package com.foro.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "topics") // ✅ Nombre explícito de la tabla
public class Topic implements Serializable { // ✅ Implementamos Serializable

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ✅ Generación automática de ID
    private Long id;

    @NotBlank(message = "El título del tópico no puede estar vacío") // ✅ Validación obligatoria
    private String title;

    @NotBlank(message = "La descripción del tópico no puede estar vacía") // ✅ Validación obligatoria
    private String description;

    private String createdBy;

    @Column(nullable = false, updatable = false) // ✅ Asegurar que nunca se actualiza
    private LocalDateTime createdAt = LocalDateTime.now(); // ✅ Asignación por defecto

    // 🔹 Constructor vacío
    public Topic() {}

    // 🔹 Constructor con parámetros
    public Topic(String title, String description, String createdBy) {
        this.title = title;
        this.description = description;
        this.createdBy = createdBy;
    }

    // 🔹 Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getCreatedBy() { return createdBy; }
    public void setCreatedBy(String createdBy) { this.createdBy = createdBy; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}