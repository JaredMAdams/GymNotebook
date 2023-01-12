package com.personal.notebook.beans.services;

import com.personal.notebook.beans.repositories.WorkoutRepo;
import com.personal.notebook.entities.Workout;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class WorkoutService {

    private final WorkoutRepo workoutRepo;

    public WorkoutService(WorkoutRepo workoutRepo) {
        this.workoutRepo = workoutRepo;
    }

    public Optional<Workout> readyByWorkoutId(Integer workoutId) {
        return this.workoutRepo.findById(workoutId);
    }

    public List<Workout> readAll() {
        return this.workoutRepo.findAll();
    }

    public List<Workout> readByPageId(Integer pageId) {
        return this.workoutRepo.findByPage_PageId(pageId);
    }

    public List<Workout> readByTitle(String title) {
        return this.workoutRepo.findByTitle(title);
    }

    public List<Workout> readByUserId(Integer userId) {
        return this.workoutRepo.findByWorkoutByUser(userId);
    }

    public Workout createWorkout(Workout workout) {
        return this.workoutRepo.save(workout);
    }

    public void deleteWorkout(Integer workoutId) {
        this.workoutRepo.deleteById(workoutId);
    }
}
