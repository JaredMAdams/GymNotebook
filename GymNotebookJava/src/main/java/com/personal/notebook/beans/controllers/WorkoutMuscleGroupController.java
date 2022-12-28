package com.personal.notebook.beans.controllers;

import com.personal.notebook.beans.services.WorkoutMuscleGroupService;
import com.personal.notebook.dtos.UserMuscleGroup;
import com.personal.notebook.entities.WorkoutMuscleGroup;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/workout-muscle-groups")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class WorkoutMuscleGroupController {

    private WorkoutMuscleGroupService workoutMuscleGroupService;

    public WorkoutMuscleGroupController(WorkoutMuscleGroupService workoutMuscleGroupService) {
        this.workoutMuscleGroupService = workoutMuscleGroupService;
    }

    @GetMapping(value = "/{workoutMuscleGroupId}")
    public ResponseEntity<WorkoutMuscleGroup> getWorkoutMuscleGroupById(@PathVariable Integer workoutMuscleGroupId) {
        Optional<WorkoutMuscleGroup> optionalWorkoutMuscleGroup = this.workoutMuscleGroupService.readByWorkoutMuscleGroupId(workoutMuscleGroupId);
        try {
            optionalWorkoutMuscleGroup.isPresent();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(optionalWorkoutMuscleGroup.get());
    }

    @GetMapping
    public ResponseEntity<List<WorkoutMuscleGroup>> getAllWorkoutMuscleGroups() {
        return ResponseEntity.ok(this.workoutMuscleGroupService.readAll());
    }



    @GetMapping(value = "/workout/{workoutId}")
    public ResponseEntity<List<WorkoutMuscleGroup>> getByWorkoutId(@PathVariable Integer workoutId) {
        return ResponseEntity.ok(this.workoutMuscleGroupService.readByWorkoutId(workoutId));
    }

    @PostMapping
    public ResponseEntity<WorkoutMuscleGroup> createWorkoutMuscleGroup(@RequestBody WorkoutMuscleGroup workoutMuscleGroup) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.workoutMuscleGroupService.createWorkoutMuscleGroup(workoutMuscleGroup));
    }

    @PostMapping(value = "/muscle-group")
    public ResponseEntity<List<WorkoutMuscleGroup>> getByMuscleGroupId(@RequestBody UserMuscleGroup userMuscleGroup) {
        return ResponseEntity.ok(this.workoutMuscleGroupService.readByMuscleGroupId(userMuscleGroup.getMuscleGroupId(), userMuscleGroup.getUserId()));
    }

    @DeleteMapping(value = "/{workoutMuscleGroupId}")
    public void deleteWorkoutMuscleGroup(@PathVariable Integer workoutMuscleGroupId) {
        this.workoutMuscleGroupService.deleteWorkoutMuscleGroup(workoutMuscleGroupId);
    }
}
