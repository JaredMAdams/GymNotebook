package com.personal.notebook.beans.repositories;

import com.personal.notebook.entities.Workout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkoutRepo extends JpaRepository<Workout, Integer> {

    List<Workout> findByPage_PageId(Integer pageId);

    List<Workout> findByTitle(String title);

    @Query(value = "SELECT * FROM  workouts w JOIN pages p ON w.page_id = p.page_id JOIN notebooks n ON p.notebook_id = n.notebook_id JOIN users u ON n.user_id = u.user_id WHERE u.user_id = :userId ORDER BY workout_id ASC", nativeQuery = true)
    List<Workout> findByWorkoutByUser(@Param("userId") Integer userId);
}
