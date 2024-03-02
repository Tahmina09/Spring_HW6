package com.example.spring6.controller;

import com.example.spring6.model.Note;
import com.example.spring6.repository.NoteRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * Контроллер для обработки заметок
 */
@RestController
@AllArgsConstructor
@RequestMapping("/notes")
public class NoteController {
    private final NoteRepository noteRepo;

    /**
     * Метод для создания заметки
     * @param note заметка
     * @return созданная заметка
     */
    @PostMapping
    public ResponseEntity<Note> createNote(@RequestBody Note note) {
        note.setCreationDate(LocalDateTime.now());
        return new ResponseEntity<>(noteRepo.save(note), HttpStatus.CREATED);
    }

    /**
     * Метод получения списка заметок
     * @return список заметок
     */
    @GetMapping
    public ResponseEntity<List<Note>> getAll() {
        return new ResponseEntity<>(noteRepo.findAll(), HttpStatus.OK);
    }

    /**
     * Метод получения заметок по идентификатору
     * @param id идентификатор заметки для поиска
     * @return найденная заметка
     */
    @GetMapping("{id}")
    public ResponseEntity<Note> getById(@PathVariable("id") Long id) {
        Optional<Note> findNote = noteRepo.findById(id);
        if (!findNote.isPresent()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Note());
        }
        return new ResponseEntity<>(findNote.get(), HttpStatus.OK);
    }

    /**
     * Метод редактирования заметки
     * @param id идентификатор заметки для редактирования
     * @param note заметка для редактирования
     * @return отредактированная заметка
     */
    @PutMapping("{id}")
    public ResponseEntity<Note> updateNote(@PathVariable("id") Long id, Note note) {
        Optional<Note> noteId = noteRepo.findById(id);
        if (noteId.isPresent()) {
            Note noteUpdate = noteId.get();
            noteUpdate.setTitle(note.getTitle());
            noteUpdate.setContent(note.getContent());
            return new ResponseEntity<>(noteRepo.save(noteUpdate), HttpStatus.OK);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Note());
    }

    /**
     * Метод удаления заметки
     * @param id идентификатор заметки для удаления
     * @return http запрос об успешном удалении заметки
     */
    @DeleteMapping({"{id}"})
    public ResponseEntity<Void> deleteNote(@PathVariable("id") Long id) {
        noteRepo.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
