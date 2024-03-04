package com.example.spring6.model;

import jakarta.persistence.*;
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
    @Column(nullable = false, length = 200)
    private String title;

    /**
     * Содержимое заметки
     */
    @Column(nullable = false)
    private String content;

    /**
     * Дата создания заметки
     */
    private LocalDateTime creationDate;
}
