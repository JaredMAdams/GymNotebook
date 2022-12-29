package com.personal.notebook.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "sets")
@Data
public class Set {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "set_id")
    private Integer setId;
    @Column
    private Integer set;
    @Column(name = "weight_goal")
    private Integer weightGoal;
    @Column(name = "rep_goal")
    private Integer repGoal;
    @Column(name = "weight_actual")
    private Integer weightActual;
    @Column(name = "rep_actual")
    private Integer repActual;
    @ManyToOne(cascade = CascadeType.MERGE)
    private WorkoutExercise workoutExercise;

}
