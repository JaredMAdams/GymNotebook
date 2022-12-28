package com.personal.notebook.beans.repositories;

import com.personal.notebook.entities.SecondaryMuscleGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SecondaryMuscleGroupRepo extends JpaRepository<SecondaryMuscleGroup, Integer> {

    List<SecondaryMuscleGroup> findByExercise_ExerciseId(Integer exerciseId);
}
