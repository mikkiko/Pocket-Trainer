package com.github.mikkiko.pockettrainer.repository;

import com.github.mikkiko.pockettrainer.entity.Training;
import com.github.mikkiko.pockettrainer.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * {@link Repository} for handling with {@link User} entity.
 */

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("select u.trainings from User u where u.id in :id")
    List<Training> getUserTrainings(Integer id);

    Optional<User> findUserByEmail(String email);

    Boolean existsUserByEmail(String email);
}
