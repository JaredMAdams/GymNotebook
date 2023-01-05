package com.personal.notebook.beans.controllers;

import com.personal.notebook.beans.services.WorkoutService;
import com.personal.notebook.entities.Workout;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/workouts")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class WorkoutController {

    private WorkoutService workoutService;

    public WorkoutController(WorkoutService workoutService) {
        this.workoutService = workoutService;
    }

    @GetMapping(value = "/{workoutId}")
    public ResponseEntity<Workout> getWorkoutById(@PathVariable Integer workoutId) {
        Optional<Workout> optionalWorkout = this.workoutService.readyByWorkoutId(workoutId);
        try {
            optionalWorkout.isPresent();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(optionalWorkout.get());
    }

    @GetMapping
    public ResponseEntity<List<Workout>> getAllWorkouts(){
        return ResponseEntity.ok(this.workoutService.readAll());
    }

    @GetMapping(value = "/page/{pageId}")
    public ResponseEntity<List<Workout>> getByPageId(@PathVariable Integer pageId) {
        return ResponseEntity.ok(this.workoutService.readByPageId(pageId));
    }

    @GetMapping(value = "/title/{title}")
    public ResponseEntity<List<Workout>> getByTitle(@PathVariable String title) {
        return ResponseEntity.ok(this.workoutService.readByTitle(title));
    }

    @GetMapping(value = "/user/{userId}")
    public ResponseEntity<List<Workout>> getByUserId(@PathVariable Integer userId) {
        return ResponseEntity.ok(this.workoutService.readByUserId(userId));
    }

    @PostMapping
    public ResponseEntity<Workout> createWorkout(@RequestBody Workout workout) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.workoutService.createWorkout(workout));
    }

    @PutMapping
    public ResponseEntity<Workout> updateWorkout(@RequestBody Workout workout) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.workoutService.createWorkout(workout));
    }

    @DeleteMapping(value = "/{workoutId}")
    public void deleteWorkout(@PathVariable Integer workoutId) {
        this.workoutService.deleteWorkout(workoutId);
    }
}
