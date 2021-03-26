package com.github.mikkiko.pockettrainer.services;

import com.github.mikkiko.pockettrainer.entity.Training;
import com.github.mikkiko.pockettrainer.entity.User;
import com.github.mikkiko.pockettrainer.exception.NoSuchUserException;
import com.github.mikkiko.pockettrainer.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Override
    public Optional<User> getUserByEmail(String email) {
        return repository.findById(email);
    }

    @Override
    public boolean saveUser(User user) {
        repository.save(user);
        return true;
    }

    @Override
    public boolean isUserExist(String email) {
        return repository.existsById(email);
    }

    @Override
    public Optional<User> deleteUserByEmail(String email) {
        Optional<User> user = repository.findById(email);;
        repository.deleteById(email);
        return user;
    }

    @Override
    public List<Training> getUsersTraining(String email) {
        return repository.getUserTrainings(email);
    }

    @Override
    public void updateTrainings(String email, Training training) throws NoSuchUserException {
        User user = repository.findById(email).orElseThrow(NoSuchUserException::new);
        user.getTrainings().add(training);
        repository.save(user);
    }

    @Override
    public void updatePassword(String email, String newPassword) throws NoSuchUserException {
        Optional<User> user = repository.findById(email);
        repository.save(user.orElseThrow(NoSuchUserException::new).setPassword(newPassword));
    }

    @Override
    @Transactional
    public List<User> getAllUsers() {
        List<User> list = repository.findAll();
        list.forEach(user -> user.getTrainings().size());
        return list;
    }
}
