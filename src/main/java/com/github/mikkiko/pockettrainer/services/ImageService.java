package com.github.mikkiko.pockettrainer.services;

import com.github.mikkiko.pockettrainer.entity.Image;

import java.util.Optional;

public interface ImageService {

    Optional<Image> getImageById(Integer id);

    boolean saveImage(Image image);

    boolean updateImageById(Integer id, byte[] imageBytes);

}
