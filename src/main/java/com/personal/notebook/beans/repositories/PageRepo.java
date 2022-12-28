package com.personal.notebook.beans.repositories;

import com.personal.notebook.entities.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PageRepo extends JpaRepository<Page, Integer> {

    List<Page> findByNotebook_NotebookId(Integer notebookId);
}
