package com.github.mikkiko.pockettrainer.services;

import com.github.mikkiko.pockettrainer.dto.TrainingDTO;
import com.github.mikkiko.pockettrainer.entity.Training;
import com.github.mikkiko.pockettrainer.exception.Cause;
import com.github.mikkiko.pockettrainer.exception.TrainingsException;
import com.github.mikkiko.pockettrainer.repository.TrainingRepository;
import com.github.mikkiko.pockettrainer.util.EntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Implementation of {@link TrainingService}.
 */

@Service
@RequiredArgsConstructor
public class TrainingServiceImpl implements TrainingService {

    private final TrainingRepository repo;
    private final EntityMapper mapper;

    @Override
    public Optional<Training> getTrainingById(Integer id) {
        return repo.findById(id);
    }

    @Override
    public TrainingDTO getTrainingDTOById(Integer id) throws TrainingsException {
        return  mapper.fromEntityToTrainingDto(repo.findById(id).orElseThrow(
                () -> new TrainingsException(Cause.TRAINING_NOT_FOUND, id)));
    }

    @Override
    public void saveTraining(TrainingDTO dto) {
        repo.save(mapper.fromTrainingDtoToEntity(dto));
    }

    @Override
    public void updateTraining(TrainingDTO dto) throws TrainingsException {
        if(repo.existsById(dto.getId())) {
            Training updated = repo.getOne(dto.getId());
            Training fromDto = mapper.fromTrainingDtoToEntity(dto);
            updated.setName(fromDto.getName())
                    .setRounds(fromDto.getRounds())
                    .setTime(fromDto.getTime())
                    .setTrainingInfo(fromDto.getTrainingInfo());
            repo.save(updated);
        } else throw new TrainingsException(Cause.TRAINING_NOT_MODIFIED, dto.getId());
    }

    @Override
    public boolean deleteTraining(Integer id) {
        repo.deleteById(id);
        return !repo.existsById(id);
    }
}
