package az.msorderservice.service;

import az.msorderservice.model.request.OrderRequest;
import az.msorderservice.model.response.OrderResponse;

public interface OrderService {
    void createOrder(OrderRequest orderRequest);
    OrderResponse getOrderByUserId(Long userId);
}
