package com.personal.notebook.beans.services;

import com.personal.notebook.beans.repositories.ExerciseRepo;
import com.personal.notebook.entities.Exercise;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExerciseService {
    private final ExerciseRepo exerciseRepo;

    public ExerciseService(ExerciseRepo exerciseRepo) {
        this.exerciseRepo = exerciseRepo;
    }

    public Optional<Exercise> readyByExerciseId(Integer exerciseId) {
        return this.exerciseRepo.findById(exerciseId);
    }

    public List<Exercise> readAll() {
        return this.exerciseRepo.findAll();
    }

    public List<Exercise> readByPrimaryMuscle(String muscleGroup) {
        return this.exerciseRepo.findByPrimaryMuscle_Name(muscleGroup);
    }

    public List<Exercise> readByCardio() {
        return this.exerciseRepo.findByCardio();
    }

    public List<Exercise> readByStrength() {
        return this.exerciseRepo.findByStrength();
    }

    public Exercise createExercise(Exercise exercise) {
        return this.exerciseRepo.save(exercise);
    }

    public Exercise updateExercise(Exercise exercise) {
        return this.exerciseRepo.save(exercise);
    }

    public void deleteExercise(Integer exerciseId) {
        this.exerciseRepo.deleteById(exerciseId);
    }
}
