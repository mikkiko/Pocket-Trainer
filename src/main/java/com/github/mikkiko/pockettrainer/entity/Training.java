package com.github.mikkiko.pockettrainer.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.List;

/**
 * Training entity.
 */

@Accessors(chain = true)
@Data
@Entity
@Table(name = "trainings")
public class Training {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private Integer rounds;

    private Integer time;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "training_id")
    private List<TrainingInfo> trainingInfo;

    @Override
    public String toString() {
        return "Training{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", rounds=" + rounds +
                ", time=" + time +
                "}\n";
    }
}
