package az.msorderservice.mapper;

import az.msorderservice.dao.entity.OrderEntity;
import az.msorderservice.model.request.OrderRequest;
import az.msorderservice.model.request.PaymentRequest;
import org.mapstruct.Mapper;

import java.util.UUID;

import static java.util.UUID.randomUUID;

@Mapper(componentModel = "spring")
public interface PaymentMapper {
    default PaymentRequest mapToRequest(
            OrderEntity entity,
            OrderRequest request,
            Double amount) {
        return PaymentRequest.builder().
                referenceNumber(randomUUID().toString()).
                type(request.getPaymentType()).
                orderId(entity.getId()).
                amount(amount).build();
    }
}
