package com.github.mikkiko.pockettrainer.controllers;

import com.github.mikkiko.pockettrainer.dto.UserDTO;
import com.github.mikkiko.pockettrainer.entity.User;
import com.github.mikkiko.pockettrainer.exception.UserException;
import com.github.mikkiko.pockettrainer.services.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * {@link RestController} for information about {@link User}.
 */

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserInfo(@PathVariable(name = "id") Integer id)
            throws UserException {
        UserDTO dto = userService.getUserDTOById(id);
        return ResponseEntity.ok(dto);
    }

    @PutMapping
    public ResponseEntity<?> updateUserTraining(@RequestBody UserDTO dto)
            throws UserException {
        userService.updateUserTrainings(dto.getId(), dto.getTrainings().get(0));
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
