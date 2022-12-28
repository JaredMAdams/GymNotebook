package com.personal.notebook.entities;

import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "secondary_muscle_group")
@Data
public class SecondaryMuscleGroup {

    @Id
    @GeneratedValue
    @Column(name = "secondary_id")
    private Integer secondaryId;
    @ManyToOne(cascade = CascadeType.MERGE)
    private Exercise exercise;
    @ManyToOne(cascade = CascadeType.MERGE)
    private MuscleGroup muscleGroup;

}