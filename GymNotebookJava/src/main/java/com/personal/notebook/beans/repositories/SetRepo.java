package com.personal.notebook.beans.repositories;

import com.personal.notebook.entities.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SetRepo extends JpaRepository<Set, Integer> {

    List<Set> findByWorkoutExercise_WorkoutExerciseId(Integer workoutExerciseId);
}
