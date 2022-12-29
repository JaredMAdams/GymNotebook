package com.personal.notebook.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "workout_exercises")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class WorkoutExercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "workout_exercise_id")
    private Integer workoutExerciseId;
    @Column
    private String notes;
    @Column
    private Float distance;
    @Column
    private Float time;
    @Column
    private Integer calories;
    @Column(name = "avg_speed")
    private Integer avgSpeed;
    @ManyToOne(cascade = CascadeType.MERGE)
    private Exercise exercise;
    @ManyToOne(cascade = CascadeType.MERGE)
    private Workout workout;
    @OneToMany(mappedBy = "workoutExercise", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Set> sets;

    @Override
    public String toString() {
        return "WorkoutExercise{" +
                "workoutExerciseId=" + workoutExerciseId +
                ", notes='" + notes + '\'' +
                ", distance=" + distance +
                ", time=" + time +
                ", calories=" + calories +
                ", avgSpeed=" + avgSpeed +
                ", exercise=" + exercise +
                ", workout=" + workout +
                '}';
    }
}
