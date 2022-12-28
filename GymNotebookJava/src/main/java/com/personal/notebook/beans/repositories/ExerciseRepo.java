package com.personal.notebook.beans.repositories;

import com.personal.notebook.entities.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ExerciseRepo extends JpaRepository<Exercise, Integer> {

    List<Exercise> findByPrimaryMuscle_Name(String muscleGroup);

    @Query(value = "SELECT * FROM exercises WHERE cardio = true", nativeQuery = true)
    List<Exercise> findByCardio();

    @Query(value = "SELECT * FROM exercises WHERE strength = true", nativeQuery = true)
    List<Exercise> findByStrength();
}
