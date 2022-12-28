package com.personal.notebook.beans.repositories;

import com.personal.notebook.entities.Notebook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NotebookRepo extends JpaRepository<Notebook, Integer> {

    Optional<Notebook> findByUser_UserId(Integer userId);
}
