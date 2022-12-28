package com.personal.notebook.entities;

import javax.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "goals")
@Data
public class Goal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "goal_id")
    private Integer goalId;
    @Column
    private Integer weight;
    @Column
    private Integer reps;
    @CreationTimestamp
    private LocalDateTime dateTime;
    @ManyToOne
    @JoinColumn(name = "user_id", unique = true)
    private User user;
    @OneToOne
    @JoinColumn(name = "exercise_id", unique = true)
    private Exercise exercise;

    public Goal() {
    }

    public Goal(Integer weight, Integer reps, LocalDateTime dateTime, User user, Exercise exercise) {
        this.weight = weight;
        this.reps = reps;
        this.dateTime = dateTime;
        this.user = user;
        this.exercise = exercise;
    }
}
