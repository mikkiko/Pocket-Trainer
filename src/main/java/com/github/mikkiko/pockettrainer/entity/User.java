package com.github.mikkiko.pockettrainer.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

import java.util.List;

@Accessors(chain = true)
@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    private String email;

    private String password;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private List<Training> trainings;

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", trainings=" + (trainings.isEmpty() ? 0 : trainings) +
                "}\n";
    }
}
/*
@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(unique = true)
 */