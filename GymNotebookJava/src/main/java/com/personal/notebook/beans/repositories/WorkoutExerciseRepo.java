package com.personal.notebook.beans.repositories;

import com.personal.notebook.entities.WorkoutExercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkoutExerciseRepo extends JpaRepository<WorkoutExercise, Integer> {

    List<WorkoutExercise> findByWorkout_WorkoutId(Integer workoutId);

    @Query(value = "SELECT * FROM workout_exercises we JOIN workouts w ON we.workout_workout_id = w.workout_id JOIN pages p ON w.page_id = p.page_id JOIN notebooks n ON p.notebook_id = n.notebook_id JOIN users u ON n.user_id = u.user_id WHERE we.exercise_exercise_id = :exerciseId AND u.user_id = :userId", nativeQuery = true)
    List<WorkoutExercise> findByUserExercise(@Param("exerciseId") Integer exerciseId, @Param("userId") Integer userId);
}
