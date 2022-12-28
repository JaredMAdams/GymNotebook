package com.personal.notebook.beans.services;

import com.personal.notebook.beans.repositories.WorkoutExerciseRepo;
import com.personal.notebook.entities.WorkoutExercise;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class WorkoutExerciseService {

    private final WorkoutExerciseRepo workoutExerciseRepo;

    public WorkoutExerciseService(WorkoutExerciseRepo workoutExerciseRepo) {
        this.workoutExerciseRepo = workoutExerciseRepo;
    }

    public Optional<WorkoutExercise> readyByWorkoutExerciseId(Integer workoutExerciseId) {
        return this.workoutExerciseRepo.findById(workoutExerciseId);
    }

    public List<WorkoutExercise> readAll() {
        return this.workoutExerciseRepo.findAll();
    }

    public List<WorkoutExercise> readByWorkoutId(Integer workoutId) {
        return this.workoutExerciseRepo.findByWorkout_WorkoutId(workoutId);
    }

    public List<WorkoutExercise> readByUserExercise(Integer exerciseId, Integer userId) {
        return this.workoutExerciseRepo.findByUserExercise(exerciseId, userId);
    }

    public WorkoutExercise createWorkoutExercise(WorkoutExercise workoutExercise) {
        return this.workoutExerciseRepo.save(workoutExercise);
    }

    public void deleteWorkoutExercise(Integer workoutExerciseId) {
        this.workoutExerciseRepo.deleteById(workoutExerciseId);
    }
}
