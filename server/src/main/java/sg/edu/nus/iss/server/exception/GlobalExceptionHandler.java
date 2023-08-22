package sg.edu.nus.iss.server.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.json.Json;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(WeatherException.class)
    public ResponseEntity<String> handleweatherException(WeatherException ex){
        return ResponseEntity.status(400)
            .body(
                Json.createObjectBuilder()
                    .add("message", ex.getMessage())
                    .build()
                    .toString()
            );
    } 
    
}
