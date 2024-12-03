package doit.blog.controller.user.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidLoginIdException.class)
    public ResponseEntity<Object> handleInvalidLoginIdException(InvalidLoginIdException ex) {
        Map<String, Object> response = new HashMap<>();
        response.put("detailStatusCode", 409001);
        response.put("message", ex.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }
}
