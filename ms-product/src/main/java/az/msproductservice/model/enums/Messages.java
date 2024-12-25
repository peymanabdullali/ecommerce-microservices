package az.msproductservice.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Messages {
    PRODUCT_NOT_FOUND("Product not found with id: %s"),
    UNEXPECTED_ERROR_OCCURRED("Unexpected error occurred"),
    INSUFFICIENT_QUANTITY("Insufficient quantity for product ID %d. Available: %d, Requested: %d");
    private final String message;

}
