package az.msorderservice.exception;

import lombok.Getter;

@Getter
public class CustomFeignClientException extends RuntimeException {
    private final Integer statusCode;

    public CustomFeignClientException(Integer statusCode, String message) {
        super(message);
        this.statusCode = statusCode;
    }
}
