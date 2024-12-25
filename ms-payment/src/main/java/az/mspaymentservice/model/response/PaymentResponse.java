package az.mspaymentservice.model.response;

import az.mspaymentservice.enums.PaymentStatus;
import az.mspaymentservice.enums.PaymentType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentResponse {
    private Long id;
    private PaymentType type;
    private PaymentStatus status;
    private LocalDateTime createdAt;
}
