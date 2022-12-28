package com.personal.notebook.beans.services;

import com.personal.notebook.beans.repositories.PageRepo;
import com.personal.notebook.entities.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PageService {

    private final PageRepo pageRepo;

    public PageService(PageRepo pageRepo) {
        this.pageRepo = pageRepo;
    }

    public Optional<Page> readyByPageId(Integer pageId) {
        return this.pageRepo.findById(pageId);
    }

    public List<Page> readAll() {
        return this.pageRepo.findAll();
    }

    public List<Page> readByNotebookId(Integer notebookId) {
        return this.pageRepo.findByNotebook_NotebookId(notebookId);
    }

    public Page createPage(Page page) {
        return this.pageRepo.save(page);
    }

    public void deletePage(Integer pageId) {
        this.pageRepo.deleteById(pageId);
    }
}
