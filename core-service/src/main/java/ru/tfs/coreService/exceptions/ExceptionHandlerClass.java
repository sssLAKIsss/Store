package ru.tfs.coreService.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class ExceptionHandlerClass {

    @ExceptionHandler(value = {CustomException.class,
                                NullPointerException.class})
    public ResponseEntity<Object> customException(Exception e) {
        HttpStatus httpStatus =
                e.getClass() == CustomException.class ?
                        HttpStatus.BAD_REQUEST : HttpStatus.NO_CONTENT;

        CustomExceptionClass customExceptionClass = new CustomExceptionClass(
                e.getMessage(),
                httpStatus,
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        return new ResponseEntity<>(customExceptionClass, httpStatus);
    }

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ResponseEntity<Object> validationExceptionHandler() {
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        CustomExceptionClass customExceptionClass = new CustomExceptionClass(
                "Не валидные данные, проверите все поля!",
                httpStatus,
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        return new ResponseEntity<>(customExceptionClass, httpStatus);
    }
}
