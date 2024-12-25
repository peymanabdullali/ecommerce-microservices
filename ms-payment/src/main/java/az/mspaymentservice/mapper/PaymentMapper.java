package az.mspaymentservice.mapper;

import az.mspaymentservice.dao.entity.PaymentEntity;
import az.mspaymentservice.model.request.PaymentRequest;
import az.mspaymentservice.model.response.PaymentResponse;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import static az.mspaymentservice.enums.PaymentStatus.SUCCESS;

@Mapper(componentModel = "spring")
public interface PaymentMapper {
    PaymentEntity mapToEntity(PaymentRequest payment);
    @AfterMapping
    default void setDefaultStatus(@MappingTarget PaymentEntity payment) {
        if (payment.getStatus() == null) {
            payment.setStatus(SUCCESS);
        }
    }

    PaymentResponse mapToResponse(PaymentEntity entity);
}
