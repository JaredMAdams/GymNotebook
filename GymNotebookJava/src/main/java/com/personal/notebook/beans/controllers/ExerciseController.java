package com.personal.notebook.beans.controllers;


import com.personal.notebook.beans.services.ExerciseService;
import com.personal.notebook.entities.Exercise;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/exercises")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class ExerciseController {
    private ExerciseService exerciseService;

    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @GetMapping(value = "/{exerciseId}")
    public ResponseEntity<Exercise> getExerciseById(@PathVariable Integer exerciseId) {
        Optional<Exercise> optionalExercise = this.exerciseService.readyByExerciseId(exerciseId);
        try {
            optionalExercise.isPresent();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(optionalExercise.get());
    }

    @GetMapping
    public ResponseEntity<List<Exercise>> getAllExercises(){
        return ResponseEntity.ok(this.exerciseService.readAll());
    }

    @GetMapping(value = "/primary/{muscleGroup}")
    public ResponseEntity<List<Exercise>> getByPrimaryMuscle(@PathVariable String muscleGroup) {
        return ResponseEntity.ok(this.exerciseService.readByPrimaryMuscle(muscleGroup));
    }

    @GetMapping(value = "/cardio")
    public ResponseEntity<List<Exercise>> getByCardio() {
        return ResponseEntity.ok(this.exerciseService.readByCardio());
    }

    @GetMapping(value = "/strength")
    public ResponseEntity<List<Exercise>> getByStrength() {
        return ResponseEntity.ok(this.exerciseService.readByStrength());
    }

    @PostMapping
    public ResponseEntity<Exercise> createExercise(@RequestBody Exercise exercise) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.exerciseService.createExercise(exercise));
    }

    @PutMapping
    public ResponseEntity<Exercise> updateExercise(@RequestBody Exercise exercise) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.exerciseService.updateExercise(exercise));
    }

    @DeleteMapping(value = "/{exerciseId}")
    public void deleteExercise(@PathVariable Integer exerciseId) {
        this.exerciseService.deleteExercise(exerciseId);
    }
}
