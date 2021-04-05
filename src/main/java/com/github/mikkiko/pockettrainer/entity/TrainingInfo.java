package com.github.mikkiko.pockettrainer.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

/**
 * Training information entity.
 */

@Data
@Entity
@Accessors(chain = true)
@Table(name = "training_x_exercises")
public class TrainingInfo {

    @Id
    @GeneratedValue
    private Integer id;

    private Integer position;

    private Integer reps;

    @ManyToOne
    @JoinColumn(name = "exercise_id")
    private Exercise exercise;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "training_id")
    private Training training;
}
