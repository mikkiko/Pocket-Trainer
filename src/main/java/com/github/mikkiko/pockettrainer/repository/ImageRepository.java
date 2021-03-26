package com.github.mikkiko.pockettrainer.repository;

import com.github.mikkiko.pockettrainer.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image, Integer> {
}
