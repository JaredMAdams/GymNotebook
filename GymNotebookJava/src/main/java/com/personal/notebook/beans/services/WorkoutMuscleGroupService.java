package com.personal.notebook.beans.services;

import com.personal.notebook.beans.repositories.WorkoutMuscleGroupRepo;
import com.personal.notebook.entities.WorkoutMuscleGroup;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkoutMuscleGroupService {

    private final WorkoutMuscleGroupRepo workoutMuscleGroupRepo;

    public WorkoutMuscleGroupService(WorkoutMuscleGroupRepo workoutMuscleGroupRepo) {
        this.workoutMuscleGroupRepo = workoutMuscleGroupRepo;
    }

    public Optional<WorkoutMuscleGroup> readByWorkoutMuscleGroupId(Integer workoutMuscleGroupId) {
        return this.workoutMuscleGroupRepo.findById(workoutMuscleGroupId);
    }

    public List<WorkoutMuscleGroup> readAll() {
        return this.workoutMuscleGroupRepo.findAll();
    }

    public List<WorkoutMuscleGroup> readByMuscleGroupId(Integer muscleGroupId, Integer userId) {
        return this.workoutMuscleGroupRepo.findByUserMuscleGroup(muscleGroupId, userId);
    }

    public List<WorkoutMuscleGroup> readByWorkoutId(Integer workoutId) {
        return this.workoutMuscleGroupRepo.findByWorkout_WorkoutId(workoutId);
    }

    public WorkoutMuscleGroup createWorkoutMuscleGroup(WorkoutMuscleGroup workoutMuscleGroup) {
        return this.workoutMuscleGroupRepo.save(workoutMuscleGroup);
    }

    public List<WorkoutMuscleGroup> createMultipleWorkoutMuscleGroups(List<WorkoutMuscleGroup> workoutMuscleGroup) {
        return this.workoutMuscleGroupRepo.saveAll(workoutMuscleGroup);
    }

    public void deleteWorkoutMuscleGroup(Integer workoutMuscleGroupId) {
        this.workoutMuscleGroupRepo.deleteById(workoutMuscleGroupId);
    }
}
