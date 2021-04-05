package com.github.mikkiko.pockettrainer.services;

import com.github.mikkiko.pockettrainer.dto.TrainingDTO;
import com.github.mikkiko.pockettrainer.dto.UserDTO;
import com.github.mikkiko.pockettrainer.entity.User;
import com.github.mikkiko.pockettrainer.exception.UserException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * {@link Service} for handling {@link User} entity.
 */

public interface UserService {

    /**
     * Find {@link User} by ID.
     *
     * @param id provided User ID
     * @return {@link User} with provided ID or null otherwise.
     */
    Optional<User> getUserById(Integer id);

    /**
     * Find {@link User} by email.
     *
     * @param email provided User email.
     * @return {@link User} with provided email or null otherwise.
     */
    Optional<User> getUserByEmail(String email);

    /**
     * Save provided {@link User} entity.
     *
     * @param user provided user.
     */
    boolean saveUser(User user);

    /**
     * Check {@link User} entity existing.
     *
     * @param email provided User email.
     * @return true if {@link User} with provided email exists or false in the other case.
     */
    boolean isUserExistByEmail(String email);

    /**
     * Retrieve all {@link User} entities.
     *
     * @return {@link List} of {@link User}.
     */
    List<User> getAllUsers();

    /**
     * Delete {@link User} by ID.
     *
     * @param id provided User ID
     * @return deleted {@link User} with provided ID or null otherwise.
     */
    Optional<User> deleteUserById(Integer id);

    /**
     * Get {@link UserDTO} by user ID.
     *
     * @param id provided User ID.
     * @return {@link UserDTO} with provided ID or null otherwise.
     * @throws UserException if {@link User} with provided id does not exist.
     */
    UserDTO getUserDTOById(Integer id) throws UserException;

    /**
     * Update {@link User} trainings list.
     *
     * @param id provided User ID.
     * @param training provided {@link TrainingDTO}.
     * @throws UserException if {@link User} with provided id does not exist.
     */
    void updateUserTrainings(Integer id, TrainingDTO training) throws UserException;

    /**
     * Update {@link User} password.
     *
     * @param id provided User ID.
     * @param newPassword provided new password.
     * @throws UserException if {@link User} with provided id does not exist.
     */
    void updatePassword(Integer id, String newPassword) throws UserException;
}
