package az.msorderservice.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Messages {

    // Order-related messages
    ORDER_NOT_FOUND("Order not found with id: %s"),

    UNEXPECTED_ERROR_OCCURRED("Unexpected error occurred"),
    CLIENT_ERROR("Client error");

    private final String message;
}
