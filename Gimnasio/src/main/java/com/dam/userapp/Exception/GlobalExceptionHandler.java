package com.dam.userapp.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleGeneralExceptions(MethodArgumentNotValidException ex) {
        List<String> errores = ex.getBindingResult().getFieldErrors().stream()
        .map(error -> error.getField() + " : " + error.getDefaultMessage())
        .toList();
        
        Map<String, Object> respuestaError = new HashMap<>();
            respuestaError.put("timestamp", LocalDateTime.now());
            respuestaError.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
            respuestaError.put("error", "Error Interno del Servidor");
            respuestaError.put("detalles", errores);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(respuestaError);
    }   
    
}