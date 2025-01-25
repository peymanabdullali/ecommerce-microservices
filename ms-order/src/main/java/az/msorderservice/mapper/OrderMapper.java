package az.msorderservice.mapper;

import az.msorderservice.dao.entity.OrderEntity;
import az.msorderservice.model.Products;
import az.msorderservice.model.request.OrderRequest;
import az.msorderservice.model.response.OrderResponse;
import az.msorderservice.model.response.PaymentResponse;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

import static az.msorderservice.enums.OrderStatus.PENDING;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    @Mapping(source = "userId", target = "userId")
    OrderEntity mapToEntity(OrderRequest request,Long userId);

    @AfterMapping
    default void setDefaultStatus(@MappingTarget OrderEntity order) {
        if (order.getOrderStatus() == null) {
            order.setOrderStatus(PENDING);
        }
    }

    @Mapping(source = "order.id", target = "id")
    @Mapping(source = "order.createdAt", target = "createdAt")
    @Mapping(source = "products", target = "products")
    @Mapping(source = "paymentResponse", target = "paymentResponse")
    OrderResponse mapToResponse(OrderEntity order, List<Products> products, PaymentResponse paymentResponse);
}
