package com.personal.notebook.beans.controllers;

import com.personal.notebook.beans.services.PageService;
import com.personal.notebook.entities.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pages")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class PageController {

    private PageService pageService;

    public PageController(PageService pageService) {
        this.pageService = pageService;
    }

    @GetMapping(value = "/{pageId}")
    public ResponseEntity<Page> getPageById(@PathVariable Integer pageId) {
        Optional<Page> optionalPage = this.pageService.readyByPageId(pageId);
        try {
            optionalPage.isPresent();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(optionalPage.get());
    }

    @GetMapping
    public ResponseEntity<List<Page>> getAllPages(){
        return ResponseEntity.ok(this.pageService.readAll());
    }

    @GetMapping(value = "/notebook/{notebookId}")
    public ResponseEntity<List<Page>> getPageByNotebook(@PathVariable Integer notebookId) {
        return ResponseEntity.ok(this.pageService.readByNotebookId(notebookId));
    }

    @PostMapping
    public ResponseEntity<Page> createPage(@RequestBody Page page) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.pageService.createPage(page));
    }

    @PutMapping
    public ResponseEntity<Page> updatePage(@RequestBody Page page) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.pageService.createPage(page));
    }

    @DeleteMapping(value = "/{pageId}")
    public void deletePage(@PathVariable Integer pageId) {
        this.pageService.deletePage(pageId);
    }
}
