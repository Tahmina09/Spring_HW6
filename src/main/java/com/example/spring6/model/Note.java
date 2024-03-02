package com.example.spring6.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDateTime;

/**
 * Класс представления заметки
 */
@Data
@Entity
@NoArgsConstructor
public class Note {
    /**
     * Идентификатор заметки
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Заголовок заметки
     */
    @NonNull
    private String title;

    /**
     * Содержимое заметки
     */
    @NonNull
    private String content;

    /**
     * Дата создания заметки
     */
    private LocalDateTime creationDate;
}
