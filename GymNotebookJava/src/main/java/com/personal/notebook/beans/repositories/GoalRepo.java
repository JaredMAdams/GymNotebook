package com.personal.notebook.beans.repositories;

import com.personal.notebook.entities.Goal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoalRepo extends JpaRepository<Goal, Integer> {

    List<Goal> findByUser_UserId(Integer userId);
}
