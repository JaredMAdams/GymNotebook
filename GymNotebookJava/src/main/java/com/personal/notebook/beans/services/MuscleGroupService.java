package com.personal.notebook.beans.services;

import com.personal.notebook.beans.repositories.MuscleGroupRepo;
import com.personal.notebook.entities.MuscleGroup;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MuscleGroupService {

    private final MuscleGroupRepo muscleGroupRepo;

    public MuscleGroupService(MuscleGroupRepo muscleGroupRepo) {
        this.muscleGroupRepo = muscleGroupRepo;
    }

    public Optional<MuscleGroup> readyByMuscleGroupId(Integer muscleGroupId) {
        return this.muscleGroupRepo.findById(muscleGroupId);
    }

    public List<MuscleGroup> readAll() {
        return this.muscleGroupRepo.findAll();
    }

    public MuscleGroup createMuscleGroup(MuscleGroup muscleGroup) {
        return this.muscleGroupRepo.save(muscleGroup);
    }

    public void deleteMuscleGroup(Integer muscleGroupId) {
        this.muscleGroupRepo.deleteById(muscleGroupId);
    }
}
