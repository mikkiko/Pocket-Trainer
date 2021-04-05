package com.github.mikkiko.pockettrainer.controllers;

import com.github.mikkiko.pockettrainer.entity.User;
import com.github.mikkiko.pockettrainer.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * {@link RestController} for registration new {@link User}.
 */

@RestController
@RequestMapping(("/sing-up"))
@RequiredArgsConstructor
public class SingUpController {

    private final UserService userService;

    @PutMapping
    public ResponseEntity<?> checkEmail(@RequestParam String email){
        Boolean b = userService.isUserExistByEmail(email);
        return ResponseEntity.ok(b);
    }

    @PostMapping
    public ResponseEntity<?> singUpNewUser(@RequestParam String email,
                                           @RequestParam String password,
                                           @RequestParam String nickname){
        User user = new User()
                .setEmail(email)
                .setPassword(password)
                .setNickname(nickname);
        boolean b = userService.saveUser(user);
        return b ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
