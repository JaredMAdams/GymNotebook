package com.personal.notebook.beans.controllers;

import com.personal.notebook.beans.services.GoalService;
import com.personal.notebook.entities.Goal;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/goals")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class GoalController {

    private GoalService goalService;

    public GoalController(GoalService goalService) {
        this.goalService = goalService;
    }

    @GetMapping(value = "/{goalId}")
    public ResponseEntity<Goal> getGoalById(@PathVariable Integer goalId) {
        Optional<Goal> optionalGoal = this.goalService.readyByGoalId(goalId);
        try {
            optionalGoal.isPresent();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(optionalGoal.get());
    }

    @GetMapping
    public ResponseEntity<List<Goal>> getAllGoals(){
        return ResponseEntity.ok(this.goalService.readAll());
    }

    @GetMapping(value = "/user/{userId}")
    public ResponseEntity<List<Goal>> getGoalsByUser(@PathVariable Integer userId) {
        return ResponseEntity.ok(this.goalService.readByUserId(userId));
    }

    @PostMapping
    public ResponseEntity<Goal> createGoal(@RequestBody Goal goal) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.goalService.createGoal(goal));
    }

    @PutMapping
    public ResponseEntity<Goal> updateGoal(@RequestBody Goal goal) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.goalService.createGoal(goal));
    }

    @DeleteMapping(value = "/{goalId}")
    public void deleteGoal(@PathVariable Integer goalId) {
        this.goalService.deleteGoal(goalId);
    }
}
