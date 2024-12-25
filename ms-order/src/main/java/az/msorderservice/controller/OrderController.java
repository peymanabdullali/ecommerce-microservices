package az.msorderservice.controller;

import az.msorderservice.model.request.OrderRequest;
import az.msorderservice.model.response.OrderResponse;
import az.msorderservice.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("v1/api/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService service;

    @GetMapping("{userId}")
    public OrderResponse getOrderByUserId(@PathVariable Long userId) {
        return service.getOrderByUserId(userId);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public void createOrder(@RequestBody @Valid OrderRequest request) {
        service.createOrder(request);
    }
}
