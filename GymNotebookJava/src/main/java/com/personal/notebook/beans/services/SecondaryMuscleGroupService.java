package com.personal.notebook.beans.services;

import com.personal.notebook.beans.repositories.SecondaryMuscleGroupRepo;
import com.personal.notebook.entities.SecondaryMuscleGroup;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SecondaryMuscleGroupService {

    private final SecondaryMuscleGroupRepo secondaryMuscleGroupRepo;

    public SecondaryMuscleGroupService(SecondaryMuscleGroupRepo secondaryMuscleGroupRepo) {
        this.secondaryMuscleGroupRepo = secondaryMuscleGroupRepo;
    }

    public Optional<SecondaryMuscleGroup> readyBySecondaryMuscleGroupId(Integer secondaryMuscleGroupId) {
        return this.secondaryMuscleGroupRepo.findById(secondaryMuscleGroupId);
    }

    public List<SecondaryMuscleGroup> readAll() {
        return this.secondaryMuscleGroupRepo.findAll();
    }

    public List<SecondaryMuscleGroup> readByExerciseId(Integer exerciseId) {
        return this.secondaryMuscleGroupRepo.findByExercise_ExerciseId(exerciseId);
    }

    public SecondaryMuscleGroup createSecondaryMuscleGroup(SecondaryMuscleGroup secondaryMuscleGroup) {
        return this.secondaryMuscleGroupRepo.save(secondaryMuscleGroup);
    }

    public List<SecondaryMuscleGroup> createMultipleSecondaryMuscleGroups(List<SecondaryMuscleGroup> secondaryMuscleGroups) {
        return this.secondaryMuscleGroupRepo.saveAll(secondaryMuscleGroups);
    }

    public void deleteSecondaryMuscleGroup(Integer secondaryMuscleGroupId) {
        this.secondaryMuscleGroupRepo.deleteById(secondaryMuscleGroupId);
    }

    public void deleteMultipleSecondaryMuscleGroups(List<SecondaryMuscleGroup> secondaryMuscleGroupIds) {
        this.secondaryMuscleGroupRepo.deleteAll(secondaryMuscleGroupIds);
    }
}
