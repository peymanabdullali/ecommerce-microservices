package az.msorderservice.exception;

import az.msorderservice.model.response.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

import static az.msorderservice.enums.Messages.UNEXPECTED_ERROR_OCCURRED;
import static org.springframework.http.HttpStatus.*;


@RestControllerAdvice
public class ErrorHandler {
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(value = NOT_FOUND)
    public ErrorResponse handle(NotFoundException exception) {
        return new ErrorResponse(exception.getMessage());
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

    @ExceptionHandler(CustomFeignClientException.class)
    public ResponseEntity<ErrorResponse> handle(CustomFeignClientException exception) {
        return ResponseEntity.status(
                exception.getStatusCode()).body(new ErrorResponse(exception.getMessage()));
    }

//    @ExceptionHandler(Exception.class)
//    @ResponseStatus(INTERNAL_SERVER_ERROR)
//    public ErrorResponse handle(Exception exception) {
//        return new ErrorResponse(UNEXPECTED_ERROR_OCCURRED.getMessage());
//    }

}
