package com.github.mikkiko.pockettrainer.services;

import com.github.mikkiko.pockettrainer.entity.Image;
import com.github.mikkiko.pockettrainer.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Implementation of {@link ImageService}.
 */

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService{

    private final ImageRepository repository;

    @Override
    public Optional<Image> getImageById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public boolean saveImage(Image image) {
        repository.save(image);
        return true;
    }

    @Override
    public boolean updateImageById(Integer id, byte[] imageBytes) {
        Optional<Image> image = repository.findById(id);
        if(image.isPresent()){
            image.get().setBytes(imageBytes);
            return true;
        }
        return false;
    }
}
