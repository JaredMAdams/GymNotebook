package com.personal.notebook.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "workout_muscle_groups")
@Data
public class WorkoutMuscleGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "workout_muscle_group_id")
    private Integer workoutMuscleGroupId;
    @ManyToOne(cascade = CascadeType.MERGE)
    private Workout workout;
    @ManyToOne(cascade = CascadeType.MERGE)
    private MuscleGroup muscleGroup;
}
