package com.github.mikkiko.pockettrainer.services;

import com.github.mikkiko.pockettrainer.dto.ExerciseDTO;
import com.github.mikkiko.pockettrainer.entity.Exercise;
import com.github.mikkiko.pockettrainer.entity.Image;
import com.github.mikkiko.pockettrainer.exception.NoSuchExerciseException;
import com.github.mikkiko.pockettrainer.repository.ExerciseRepository;
import com.github.mikkiko.pockettrainer.util.EntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExerciseServiceImpl implements ExercisesService {

    private final ExerciseRepository repo;
    private final EntityMapper mapper;

    @Override
    public void saveExercise(Exercise exercise) {
        repo.save(exercise);
    }

    @Override
    public ExerciseDTO getExerciseDTOById(Integer id) {
        ExerciseDTO dto = null;
        try {
            dto = mapper.fromEntityToExerciseDto(repo.findById(id).orElseThrow(NoSuchExerciseException::new));
        } catch (NoSuchExerciseException e) {
            e.printStackTrace();
        }
        return dto;
    }

    @Override
    public List<ExerciseDTO> getAllExercisesDTO() {
        return mapper.fromEntityToExerciseDtoList(repo.findAll());
    }

    @Override
    public boolean removeExerciseById(Integer id) {
        repo.deleteById(id);
        return !repo.existsById(id);
    }

    @Override
    public Optional<Image> getExerciseImage(Integer id) {
        return repo.findImageById(id);
    }
}
