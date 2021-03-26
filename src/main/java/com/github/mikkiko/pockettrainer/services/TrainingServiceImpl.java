package com.github.mikkiko.pockettrainer.services;

import com.github.mikkiko.pockettrainer.entity.Training;
import com.github.mikkiko.pockettrainer.repository.TrainingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TrainingServiceImpl implements TrainingService {

    private final TrainingRepository repository;

    @Override
    public Optional<Training> getTrainingById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public boolean saveTraining(Training training) {
        repository.save(training);
        return repository.existsById(training.getId());
    }

    @Override
    public boolean deleteTraining(Integer id) {
        repository.deleteById(id);
        return !repository.existsById(id);
    }

    @Override
    public boolean updateTraining(Training newTraining) {
        Optional<Training> oldTraining = repository.findById(newTraining.getId());
        if(oldTraining.isPresent()){
            repository.save(newTraining);
            return true;
        }
        return false;
    }
}
