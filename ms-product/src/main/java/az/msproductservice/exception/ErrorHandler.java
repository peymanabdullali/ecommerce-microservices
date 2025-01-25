package az.msproductservice.exception;

import az.msproductservice.model.response.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

import static az.msproductservice.model.enums.Messages.INSUFFICIENT_QUANTITY;
import static az.msproductservice.model.enums.Messages.UNEXPECTED_ERROR_OCCURRED;
import static org.springframework.http.HttpStatus.*;

@RestControllerAdvice
public class ErrorHandler {
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(NOT_FOUND)
    public ErrorResponse handle(NotFoundException exception) {
        return new ErrorResponse(exception.getMessage());
    }
    @ExceptionHandler(InsufficientQuantityException.class)
    @ResponseStatus(BAD_REQUEST)
    public ErrorResponse handle(InsufficientQuantityException exception) {
        return new ErrorResponse(exception.getMessage());
    }

    @ExceptionHandler(UnauthorizedUserException.class)
    @ResponseStatus(BAD_REQUEST)
    public ResponseEntity<ErrorResponse> handle(UnauthorizedUserException exception) {
        return new ResponseEntity<>(new ErrorResponse(exception.getMessage()), UNAUTHORIZED);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handle(MethodArgumentNotValidException exception) {
        Map<String, String> errors = new HashMap<>();
        exception.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return new ResponseEntity<>(errors, BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    public ErrorResponse handle(Exception exception) {
        return new ErrorResponse(UNEXPECTED_ERROR_OCCURRED.getMessage());
    }
}
