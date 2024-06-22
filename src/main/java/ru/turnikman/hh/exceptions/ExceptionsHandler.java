package ru.turnikman.hh.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.UUID;

@Slf4j
@ControllerAdvice
@Component
public class ExceptionsHandler {
    @ExceptionHandler(HhException.class)
    public ResponseEntity<ErrorResponse> handleHhException(HhException e) {
        String uuid = UUID.randomUUID().toString();
        log.error("Exception: {}), uuid:{}", e.getMessage(), uuid );
        return ResponseEntity.badRequest().body(new ErrorResponse(400L,"Что-то пошло не так, уже исправляем. Пожалуйста, обратитесь с номером ошибки: " + uuid ));
    }
}
