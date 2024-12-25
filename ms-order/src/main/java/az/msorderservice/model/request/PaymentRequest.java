package az.msorderservice.model.request;

import az.msorderservice.enums.PaymentType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaymentRequest {
    private Long orderId;
    private String referenceNumber;
    private Double amount;
    private PaymentType type;
}
