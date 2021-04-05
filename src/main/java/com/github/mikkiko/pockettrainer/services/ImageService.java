package com.github.mikkiko.pockettrainer.services;

import com.github.mikkiko.pockettrainer.entity.Image;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * {@link Service} for handling {@link Image} entity.
 */

public interface ImageService {

    /**
     * Find {@link Image} entity.
     *
     * @param id provided {@link Image} ID.
     * @return {@link Image} with provided ID or null otherwise.
     */
    Optional<Image> getImageById(Integer id);

    /**
     * Save provided {@link Image} entity.
     *
     * @param image provided {@link Image}.
     * @return true if provided {@link Image} was saved successfully or false in the other case.
     */
    boolean saveImage(Image image);

    /**
     * Update {@link Image} entity with provided ID.
     *
     * @param id provided {@link Image} ID.
     * @param imageBytes provided {@link Image} bytes.
     * @return true if provided {@link Image} was updated successfully or false in the other case.
     */
    boolean updateImageById(Integer id, byte[] imageBytes);

}
