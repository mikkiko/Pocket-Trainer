package com.github.mikkiko.pockettrainer.services;

import com.github.mikkiko.pockettrainer.entity.Training;
import com.github.mikkiko.pockettrainer.entity.User;
import com.github.mikkiko.pockettrainer.exception.NoSuchUserException;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<User> getUserByEmail(String email);

    boolean saveUser(User user);

    boolean isUserExist(String email);

    Optional<User> deleteUserByEmail(String email);

    List<Training> getUsersTraining(String email);

    void updateTrainings(String email, Training training) throws NoSuchUserException;

    void updatePassword(String email, String newPassword) throws NoSuchUserException;

    List<User> getAllUsers();
}
