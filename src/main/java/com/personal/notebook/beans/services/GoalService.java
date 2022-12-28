package com.personal.notebook.beans.services;

import com.personal.notebook.beans.repositories.GoalRepo;
import com.personal.notebook.entities.Goal;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GoalService {

    private final GoalRepo goalRepo;

    public GoalService(GoalRepo goalRepo) {
        this.goalRepo = goalRepo;
    }

    public Optional<Goal> readyByGoalId(Integer goalId) {
        return this.goalRepo.findById(goalId);
    }

    public List<Goal> readAll() {
        return this.goalRepo.findAll();
    }

    public List<Goal> readByUserId(Integer userId) {
        return this.goalRepo.findByUser_UserId(userId);
    }

    public Goal createGoal(Goal goal) {
        return this.goalRepo.save(goal);
    }

    public void deleteGoal(Integer goalId) {
        this.goalRepo.deleteById(goalId);
    }
}
