package az.mspaymentservice.exception;

import lombok.Builder;

@Builder
public record ErrorResponse(String message) {
}
