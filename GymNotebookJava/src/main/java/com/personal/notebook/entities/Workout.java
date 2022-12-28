package com.personal.notebook.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "workouts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Workout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer workoutId;
    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createDateTime;
    @Column
    private String title;
    @ManyToOne
    @JoinColumn(name = "page_id")
    private Page page;
    @OneToMany(mappedBy = "workout", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<WorkoutExercise> workoutExercises;
    @OneToMany(mappedBy = "workout", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<WorkoutMuscleGroup> workoutMuscleGroups;

    public Workout(LocalDateTime createDateTime, String title, Page page, List<WorkoutExercise> workoutExercises, List<WorkoutMuscleGroup> workoutMuscleGroups) {
        this.createDateTime = createDateTime;
        this.title = title;
        this.page = page;
        this.workoutExercises = workoutExercises;
        this.workoutMuscleGroups = workoutMuscleGroups;
    }

    @Override
    public String toString() {
        return "Workout{" +
                "workoutId=" + workoutId +
                ", createDateTime=" + createDateTime +
                ", title='" + title + '\'' +
                ", page=" + page +
                '}';
    }
}
