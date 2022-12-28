package com.personal.notebook.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "workout_exercises")
@Data
public class WorkoutExercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "workout_exercise_id")
    private Integer workoutExerciseId;
    @Column
    private String notes;
    @Column(name = "weight_goal")
    private Integer weightGoal;
    @Column(name = "rep_goal")
    private Integer repGoal;
    @Column(name = "weight_actual")
    private Integer weightActual;
    @Column(name = "rep_actual")
    private Integer repActual;
    @Column
    private Float distance;
    @Column
    private Float time;
    @Column
    private Integer calories;
    @Column
    private Integer set;
    @Column(name = "avg_speed")
    private Integer avgSpeed;
    @ManyToOne(cascade = CascadeType.MERGE)
    private Exercise exercise;
    @ManyToOne(cascade = CascadeType.MERGE)
    private Workout workout;

}
