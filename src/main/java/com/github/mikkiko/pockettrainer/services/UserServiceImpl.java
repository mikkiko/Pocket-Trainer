package com.github.mikkiko.pockettrainer.services;

import com.github.mikkiko.pockettrainer.dto.TrainingDTO;
import com.github.mikkiko.pockettrainer.dto.UserDTO;
import com.github.mikkiko.pockettrainer.entity.User;
import com.github.mikkiko.pockettrainer.exception.NoSuchUserException;
import com.github.mikkiko.pockettrainer.repository.UserRepository;
import com.github.mikkiko.pockettrainer.util.EntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repo;
    private final EntityMapper mapper;

    @Override
    public Optional<User> getUser(String email) {
        return repo.findById(email);
    }

    @Override
    public boolean saveUser(User user) {
        repo.save(user);
        return repo.existsById(user.getEmail());
    }

    @Override
    public boolean isUserExist(String email) {
        return repo.existsById(email);
    }

    @Override
    public Optional<User> deleteUserByEmail(String email) {
        Optional<User> user = repo.findById(email);
        ;
        repo.deleteById(email);
        return user;
    }

    @Override
    public UserDTO getUserDTO(String email) {
        UserDTO dto = null;
        try {
            dto = mapper.fromEntityToUserDto(repo.findById(email).orElseThrow(NoSuchUserException::new));
        } catch (NoSuchUserException e) {
            e.printStackTrace();
        }
        return dto;
    }

    @Override
    public boolean updateUserTrainings(String email, TrainingDTO training) {
        try {
            User user = repo.findById(email).orElseThrow(NoSuchUserException::new);
            user.getTrainings().add(mapper.fromTrainingDtoToEntity(training));
            repo.save(user);
            return true;
        } catch (NoSuchUserException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updatePassword(String email, String newPassword) {
        if (repo.existsById(email)) {
            User user = repo.getOne(email);
            repo.save(user.setPassword(newPassword));
            return true;
        } else
            return false;
    }

    @Override
    @Transactional
    public List<User> getAllUsers() {
        List<User> list = repo.findAll();
        list.forEach(user -> user.getTrainings().size());
        return list;
    }
}
