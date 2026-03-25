package com.ecommerce.exception;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Map;

@Data
public class ErrorResponse {

    private LocalDateTime timestamp;
    private int status;
    private String error;
    private String message;
    private String path;
    private Map<String, String> errors;

    // Constructors, Getters, Setters are created using @Data annotation by Lombok
}
