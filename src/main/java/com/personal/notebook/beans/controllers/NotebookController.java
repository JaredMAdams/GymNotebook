package com.personal.notebook.beans.controllers;

import com.personal.notebook.beans.services.NotebookService;
import com.personal.notebook.entities.Notebook;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/notebooks")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class NotebookController {

    private NotebookService notebookService;

    public NotebookController(NotebookService notebookService) {
        this.notebookService = notebookService;
    }

    @GetMapping(value = "/{notebookId}")
    public ResponseEntity<Notebook> getNotebookById(@PathVariable Integer notebookId) {
        Optional<Notebook> optionalNotebook = this.notebookService.readyByNotebookId(notebookId);
        try {
            optionalNotebook.isPresent();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(optionalNotebook.get());
    }

    @GetMapping(value = "/user/{userId}")
    public ResponseEntity<Notebook> getNotebookByUserId(@PathVariable Integer userId) {
        Optional<Notebook> optionalNotebook = this.notebookService.readByUserId(userId);
        try {
            optionalNotebook.isPresent();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(optionalNotebook.get());
    }

    @GetMapping
    public ResponseEntity<List<Notebook>> getAllNotebooks(){
        return ResponseEntity.ok(this.notebookService.readAll());
    }

    @PostMapping
    public ResponseEntity<Notebook> createNotebook(@RequestBody Notebook notebook) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.notebookService.createNotebook(notebook));
    }

    @PutMapping
    public ResponseEntity<Notebook> updateNotebook(@RequestBody Notebook notebook) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.notebookService.createNotebook(notebook));
    }

    @DeleteMapping(value = "/{notebookId}")
    public void deleteNotebook(@PathVariable Integer notebookId) {
        this.notebookService.deleteNotebook(notebookId);
    }
}
