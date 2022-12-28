package com.personal.notebook.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "muscle_groups")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class MuscleGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "muscle_group_id")
    private Integer muscleGroupId;
    @Column
    private String name;
    @OneToMany(mappedBy = "primaryMuscle")
    @JsonIgnore
    private List<Exercise> primaryExercises;
    @OneToMany(mappedBy = "muscleGroup", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<SecondaryMuscleGroup> secondaryExerciseMuscleGroups;
    @OneToMany(mappedBy = "muscleGroup", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<WorkoutMuscleGroup> workoutMuscleGroups;

    public MuscleGroup(String name, List<Exercise> primaryExercises, List<SecondaryMuscleGroup> secondaryExerciseMuscleGroups, List<WorkoutMuscleGroup> workoutMuscleGroups) {
        this.name = name;
        this.primaryExercises = primaryExercises;
        this.secondaryExerciseMuscleGroups = secondaryExerciseMuscleGroups;
        this.workoutMuscleGroups = workoutMuscleGroups;
    }

    @Override
    public String toString() {
        return "MuscleGroup{" +
                "muscleGroupId=" + muscleGroupId +
                ", name='" + name + '\'' +
                '}';
    }
}
