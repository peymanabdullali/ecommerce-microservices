package az.msorderservice.service.impl;

import az.msorderservice.client.PaymentClient;
import az.msorderservice.client.ProductClient;
import az.msorderservice.dao.entity.OrderEntity;
import az.msorderservice.dao.repository.OrderRepository;
import az.msorderservice.exception.NotFoundException;
import az.msorderservice.mapper.OrderMapper;
import az.msorderservice.mapper.PaymentMapper;
import az.msorderservice.model.Products;
import az.msorderservice.model.request.OrderRequest;
import az.msorderservice.model.response.OrderResponse;
import az.msorderservice.model.response.PaymentResponse;
import az.msorderservice.model.response.ProductResponse;
import az.msorderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

import static az.msorderservice.enums.OrderStatus.APPROVED;
import static az.msorderservice.enums.OrderStatus.REJECTED;
import static az.msorderservice.enums.Messages.ORDER_NOT_FOUND;
import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final PaymentMapper paymentMapper;
    private final ProductClient productClient;
    private final PaymentClient paymentClient;

    @Override
    @Transactional
    public void createOrder(OrderRequest orderRequest, Long userId) {
        OrderEntity orderEntity = orderMapper.mapToEntity(orderRequest,userId);
        orderRepository.save(orderEntity);
        List<ProductResponse> productList =
                productClient.getProductsByIds(orderRequest.getProducts().keySet().
                        stream().
                        toList());
        double amount =
                productList.
                        stream().
                        mapToDouble(i -> i.getPrice() * orderRequest.getProducts().get(i.getId())).
                        sum();
        try {
            paymentClient.createPayment(paymentMapper.mapToRequest(orderEntity, orderRequest, amount));
            productClient.updateQuantity(orderRequest.getProducts());
            orderEntity.setOrderStatus(APPROVED);
        } catch (Exception e) {
            orderEntity.setOrderStatus(REJECTED);
        }
        orderEntity.setAmount(amount);
    }

    @Override
    public OrderResponse getOrderByUserId(Long userId) {
        OrderEntity orderEntity = orderRepository.findByUserId(userId).orElseThrow(() ->
                new NotFoundException(format(ORDER_NOT_FOUND.getMessage(), userId)));
        List<ProductResponse> productList =
                productClient.getProductsByIds(orderEntity.getProducts().keySet().
                        stream().
                        toList());
            List<Products> list = productList.stream().
                map(product -> new Products(product, orderEntity.getProducts().get(product.getId()))).
                toList();
        PaymentResponse paymentResponse = paymentClient.getPaymentByOrderId(orderEntity.getId());
        return orderMapper.mapToResponse(orderEntity, list,paymentResponse);
    }
}
