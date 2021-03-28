package com.github.mikkiko.pockettrainer.controllers;

import com.github.mikkiko.pockettrainer.entity.User;
import com.github.mikkiko.pockettrainer.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController("/login")
@RequiredArgsConstructor
public class LoginController {

    private final UserService userService;

    @PostMapping("/singup")
    public ResponseEntity<?> addUser(@RequestParam String email, @RequestParam String password) {
        User user = new User()
                .setEmail(email)
                .setPassword(password)
                .setTrainings(new ArrayList<>());
        boolean b = userService.saveUser(user);
        return b ? new ResponseEntity<>(HttpStatus.OK)
                 : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
