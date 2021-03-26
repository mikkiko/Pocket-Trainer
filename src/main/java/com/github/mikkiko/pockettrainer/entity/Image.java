package com.github.mikkiko.pockettrainer.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;


@Entity
@Data
@Accessors(chain = true)
@Table(name = "images")
public class Image {

    @Id
    @GeneratedValue
    private Integer id;

    @OneToOne(mappedBy = "image", cascade = CascadeType.ALL)
    private Exercise exercise;

    private byte[] bytes;

    @Override
    public String toString() {
        return "Image{" +
                "id=" + id +
                ", bytes=" + (bytes==null ? 0 : bytes.length) +
                "}\n";
    }
}
