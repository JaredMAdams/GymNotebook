package com.personal.notebook.beans.services;

import com.personal.notebook.beans.repositories.NotebookRepo;
import com.personal.notebook.entities.Notebook;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotebookService {

    private final NotebookRepo notebookRepo;

    public NotebookService(NotebookRepo notebookRepo) {
        this.notebookRepo = notebookRepo;
    }

    public Optional<Notebook> readyByNotebookId(Integer notebookId) {
        return this.notebookRepo.findById(notebookId);
    }

    public Optional<Notebook> readByUserId(Integer userId) {
        return this.notebookRepo.findByUser_UserId(userId);
    }

    public List<Notebook> readAll() {
        return this.notebookRepo.findAll();
    }

    public Notebook createNotebook(Notebook notebook) {
        return this.notebookRepo.save(notebook);
    }

    public void deleteNotebook(Integer notebookId) {
        this.notebookRepo.deleteById(notebookId);
    }
}
