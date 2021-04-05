package com.github.mikkiko.pockettrainer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Class for transport messages and errors.
 */

@Data
@AllArgsConstructor
public class Response {

    private String message;
    private String error;
}
