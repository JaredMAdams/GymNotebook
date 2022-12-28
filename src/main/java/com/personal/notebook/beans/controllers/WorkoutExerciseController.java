package com.personal.notebook.beans.controllers;

import com.personal.notebook.beans.services.WorkoutExerciseService;
import com.personal.notebook.dtos.UserExercise;
import com.personal.notebook.entities.WorkoutExercise;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/workout-exercises")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class WorkoutExerciseController {

    private WorkoutExerciseService workoutExerciseService;

    public WorkoutExerciseController(WorkoutExerciseService workoutExerciseService) {
        this.workoutExerciseService = workoutExerciseService;
    }

    @GetMapping(value = "/{workoutExerciseId}")
    public ResponseEntity<WorkoutExercise> getWorkoutExerciseById(@PathVariable Integer workoutExerciseId) {
        Optional<WorkoutExercise> optionalWorkoutExercise = this.workoutExerciseService.readyByWorkoutExerciseId(workoutExerciseId);
        try {
            optionalWorkoutExercise.isPresent();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(optionalWorkoutExercise.get());
    }

    @GetMapping
    public ResponseEntity<List<WorkoutExercise>> getAllWorkoutExercises(){
        return ResponseEntity.ok(this.workoutExerciseService.readAll());
    }

    @GetMapping(value = "/workout/{workoutId}")
    public ResponseEntity<List<WorkoutExercise>> getByWorkoutId(@PathVariable Integer workoutId) {
        return ResponseEntity.ok(this.workoutExerciseService.readByWorkoutId(workoutId));
    }

    @PostMapping
    public ResponseEntity<WorkoutExercise> createWorkoutExercise(@RequestBody WorkoutExercise workoutExercise) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.workoutExerciseService.createWorkoutExercise(workoutExercise));
    }

    @PostMapping(value = "/user-exercise")
    public ResponseEntity<List<WorkoutExercise>> getByUserExercise(@RequestBody UserExercise userExercise) {
        return ResponseEntity.ok(this.workoutExerciseService.readByUserExercise(userExercise.getExerciseId(), userExercise.getUserId()));
    }

    @PutMapping
    public ResponseEntity<WorkoutExercise> updateWorkoutExercise(@RequestBody WorkoutExercise workoutExercise) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.workoutExerciseService.createWorkoutExercise(workoutExercise));
    }

    @DeleteMapping(value = "/{workoutExerciseId}")
    public void deleteWorkoutExercise(@PathVariable Integer workoutExerciseId) {
        this.workoutExerciseService.deleteWorkoutExercise(workoutExerciseId);
    }
}
