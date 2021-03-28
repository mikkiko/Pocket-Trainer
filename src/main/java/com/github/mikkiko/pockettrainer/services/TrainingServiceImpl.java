package com.github.mikkiko.pockettrainer.services;

import com.github.mikkiko.pockettrainer.dto.TrainingDTO;
import com.github.mikkiko.pockettrainer.entity.Training;
import com.github.mikkiko.pockettrainer.exception.NoSuchTrainingException;
import com.github.mikkiko.pockettrainer.repository.TrainingRepository;
import com.github.mikkiko.pockettrainer.util.EntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
    public TrainingDTO getTrainingDTOById(Integer id) {
        TrainingDTO dto = null;
        try {
            dto = mapper.fromEntityToTrainingDto(repo.findById(id).orElseThrow(NoSuchTrainingException::new));
        } catch (NoSuchTrainingException e) {
            e.printStackTrace();
        }
        return dto;
    }

    @Override
    public void saveTraining(TrainingDTO dto) {
        repo.save(mapper.fromTrainingDtoToEntity(dto));
    }

    @Override
    public boolean updateTraining(TrainingDTO dto) {
        if(repo.existsById(dto.getId())) {
            Training updated = repo.getOne(dto.getId());
            Training fromDto = mapper.fromTrainingDtoToEntity(dto);
            updated.setName(fromDto.getName())
                    .setRounds(fromDto.getRounds())
                    .setTime(fromDto.getTime())
                    .setTrainingInfo(fromDto.getTrainingInfo());
            repo.save(updated);
            return true;
        } else return false;
    }

    @Override
    public boolean deleteTraining(Integer id) {
        repo.deleteById(id);
        return !repo.existsById(id);
    }
}
