package com.personal.notebook.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import javax.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "exercises")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exercise_id")
    private Integer exerciseId;
    @Column
    private String name;
    @Column
    private boolean strength;
    @Column
    private boolean cardio;
    @ManyToOne
    @JoinColumn(name = "primary_muscle_id")
    private MuscleGroup primaryMuscle;
    @OneToMany(mappedBy = "exercise", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<SecondaryMuscleGroup> secondaryExerciseMuscleGroup;
    @OneToMany(mappedBy = "exercise", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<WorkoutExercise> workoutExercises;
    @OneToOne(mappedBy = "exercise")
    @JsonIgnore
    private Goal goal;

    public Exercise(String name, boolean strength, boolean cardio, MuscleGroup primaryMuscle, List<SecondaryMuscleGroup> secondaryExerciseMuscleGroup, List<WorkoutExercise> workoutExercises, Goal goal) {
        this.name = name;
        this.strength = strength;
        this.cardio = cardio;
        this.primaryMuscle = primaryMuscle;
        this.secondaryExerciseMuscleGroup = secondaryExerciseMuscleGroup;
        this.workoutExercises = workoutExercises;
        this.goal = goal;
    }

    @Override
    public String toString() {
        return "Exercise{" +
                "exerciseId=" + exerciseId +
                ", name='" + name + '\'' +
                ", strength=" + strength +
                ", cardio=" + cardio +
                ", primaryMuscle=" + primaryMuscle +
                ", goal=" + goal +
                '}';
    }
}