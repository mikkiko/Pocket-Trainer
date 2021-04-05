package com.github.mikkiko.pockettrainer.services;

import com.github.mikkiko.pockettrainer.dto.TrainingDTO;
import com.github.mikkiko.pockettrainer.dto.UserDTO;
import com.github.mikkiko.pockettrainer.entity.User;
import com.github.mikkiko.pockettrainer.exception.Cause;
import com.github.mikkiko.pockettrainer.exception.UserException;
import com.github.mikkiko.pockettrainer.repository.UserRepository;
import com.github.mikkiko.pockettrainer.util.EntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of {@link UserService}.
 */

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repo;
    private final EntityMapper mapper;

    @Override
    public Optional<User> getUserById(Integer id) {
        return repo.findById(id);
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return repo.findUserByEmail(email);
    }

    @Override
    public boolean saveUser(User user) {
        repo.save(user);
        return repo.existsById(user.getId());
    }

    @Override
    public boolean isUserExistByEmail(String email) {
        return repo.existsUserByEmail(email);
    }

    @Override
    public Optional<User> deleteUserById(Integer id) {
        Optional<User> user = repo.findById(id);
        repo.deleteById(id);
        return user;
    }

    @Override
    public  UserDTO getUserDTOById(Integer id) throws UserException {
        return mapper.fromEntityToUserDto(repo.findById(id).orElseThrow(
                () -> new UserException(Cause.USER_NOT_FOUND, id)));
    }

    @Override
    public void updateUserTrainings(Integer id, TrainingDTO training) throws UserException {
            User user = repo.findById(id).orElseThrow(
                    () -> new UserException(Cause.USER_NOT_MODIFIED, id));
            user.getTrainings().add(mapper.fromTrainingDtoToEntity(training));
            repo.save(user);
    }

    @Override
    public void updatePassword(Integer id, String newPassword) throws UserException {
        if (repo.existsById(id)) {
            User user = repo.getOne(id);
            repo.save(user.setPassword(newPassword));
        } else throw new UserException(Cause.USER_NOT_MODIFIED, id);
    }

    @Override
    @Transactional
    public List<User> getAllUsers() {
        List<User> list = repo.findAll();
        list.forEach(user -> user.getTrainings().size());
        return list;
    }
}
