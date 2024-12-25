package az.msproductservice.model.response;

import lombok.Builder;

@Builder
public record ErrorResponse(String message) {
}
