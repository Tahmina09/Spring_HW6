package com.example.spring6.repository;

import com.example.spring6.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Интерфейс репозитория для работы с заметками
 */
public interface NoteRepository extends JpaRepository<Note, Long> {
    /**
     * Метод поиска по идентификатору
     * @param id идентификатор заметки
     * @return найденная заметка
     */
    @Override
    Optional<Note> findById(Long id);
}
