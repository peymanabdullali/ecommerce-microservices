package az.msorderservice.model.response;

import lombok.Builder;

@Builder
public record ErrorResponse(String message) {
}
