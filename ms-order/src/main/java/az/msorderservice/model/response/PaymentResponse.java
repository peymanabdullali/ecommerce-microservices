package az.msorderservice.model.response;


import az.msorderservice.enums.PaymentStatus;
import az.msorderservice.enums.PaymentType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class    PaymentResponse {
    private Long id;
    private PaymentType type;
    private PaymentStatus status;
    private LocalDateTime createdAt;
}
