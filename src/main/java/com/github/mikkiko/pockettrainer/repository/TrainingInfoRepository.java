package com.github.mikkiko.pockettrainer.repository;

import com.github.mikkiko.pockettrainer.entity.TrainingInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * {@link Repository} for handling with {@link TrainingInfo} entity.
 */

@Repository
public interface TrainingInfoRepository extends JpaRepository<TrainingInfo, Integer> {
}
