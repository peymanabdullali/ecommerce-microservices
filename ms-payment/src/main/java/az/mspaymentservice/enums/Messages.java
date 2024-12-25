package az.mspaymentservice.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Messages {
    PAYMENT_NOT_FOUND("Payment not found with orderId: %s"),
    SERVER_ERROR("Unexpected error occurred.");
    private final String message;
}
