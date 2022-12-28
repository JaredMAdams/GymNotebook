package com.personal.notebook.beans.repositories;

import com.personal.notebook.entities.Workout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkoutRepo extends JpaRepository<Workout, Integer> {

    List<Workout> findByPage_PageId(Integer pageId);

    List<Workout> findByTitle(String title);
}
