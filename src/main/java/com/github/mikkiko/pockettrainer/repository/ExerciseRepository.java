package com.github.mikkiko.pockettrainer.repository;

import com.github.mikkiko.pockettrainer.entity.Exercise;
import com.github.mikkiko.pockettrainer.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Integer> {

    @Query("SELECT e.image FROM Exercise e WHERE e.id = :id")
    Optional<Image> findImageById(Integer id);
}
