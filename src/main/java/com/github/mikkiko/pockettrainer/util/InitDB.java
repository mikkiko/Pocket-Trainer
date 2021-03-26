package com.github.mikkiko.pockettrainer.util;

import com.github.mikkiko.pockettrainer.entity.Exercise;
import com.github.mikkiko.pockettrainer.entity.Image;
import com.github.mikkiko.pockettrainer.entity.User;
import com.github.mikkiko.pockettrainer.services.ExercisesService;
import com.github.mikkiko.pockettrainer.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InitDB implements ApplicationRunner {

    private final ExercisesService exercisesService;
    private final UserService userService;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        uploadUsers();
        uploadExercises();
        System.out.println(exercisesService.getAllExercises());
        System.out.println(userService.getAllUsers());
    }

    @Transactional
    public void uploadUsers() {
        for (int i = 0; i < 5; i++) {
            userService.saveUser(new User()
                    .setEmail("abs" + i + "@mail.com")
                    .setPassword("" + 1000 * i * 34)
                    .setTrainings(new ArrayList<>()));
        }
        System.out.println("Users uploaded");
    }

    public void uploadExercises() {
        try {
            File descriptionPath = new ClassPathResource("/exercises/description/").getFile();
            File imagePath = new ClassPathResource("/exercises/images/").getFile();
            List<String> descriptions = Arrays.asList(descriptionPath.list());

            for (String a : descriptions) {
                String name = "none";
                String description = "none";
                byte[] image = {0};
                try {
                    name = a.substring(0, a.lastIndexOf("."));
                    description = FileUtils.extractString(new File(descriptionPath, a));
                    image = FileUtils.extractBytes(new File(imagePath, name + ".png"));
                } catch (IOException e) {
                    System.out.println(e.getMessage() + " : Problems with path to file");
                }
                exercisesService.saveExercise(new Exercise()
                        .setName(name)
                        .setDescription(description)
                        .setImage(new Image().setBytes(image)));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage() + " : Problems with path to folder");
        }
        System.out.println("Exercises uploaded");
    }
}