package com.github.mikkiko.pockettrainer.services;

import com.github.mikkiko.pockettrainer.dto.TrainingDTO;
import com.github.mikkiko.pockettrainer.dto.UserDTO;
import com.github.mikkiko.pockettrainer.entity.Training;
import com.github.mikkiko.pockettrainer.entity.User;
import com.github.mikkiko.pockettrainer.exception.NoSuchUserException;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<User> getUser(String email);

    boolean saveUser(User user);

    boolean isUserExist(String email);

    List<User> getAllUsers();

    Optional<User> deleteUserByEmail(String email);

    UserDTO getUserDTO(String email);

    boolean updateUserTrainings(String email, TrainingDTO training);

    boolean updatePassword(String email, String newPassword);
}
