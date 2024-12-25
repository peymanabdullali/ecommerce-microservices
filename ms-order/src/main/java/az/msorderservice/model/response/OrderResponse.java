package az.msorderservice.model.response;

import az.msorderservice.model.Products;
import az.msorderservice.enums.OrderStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;
import java.util.List;


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponse {
    private Long id;
    private OrderStatus orderStatus;
    private Double amount;
    private LocalDate createdAt;
    private List<Products> products;
    private PaymentResponse paymentResponse;
}
