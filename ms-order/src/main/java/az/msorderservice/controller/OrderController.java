package az.msorderservice.controller;

import az.msorderservice.model.request.OrderRequest;
import az.msorderservice.model.response.OrderResponse;
import az.msorderservice.service.OrderService;
import az.msorderservice.validation.CheckPermission;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static java.lang.Long.getLong;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("v1/api/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService service;

    @GetMapping
//    @CheckPermission("ROLE_USER")
    public OrderResponse getOrderByUserId(@RequestHeader(value = "UserId",required = false) String userId) {
        System.out.println(userId);
        return service.getOrderByUserId(getLong(userId));
    }

    @PostMapping
    @ResponseStatus(CREATED)
//    @CheckPermission("ROLE_USER")
    public void createOrder(
            @RequestBody @Valid OrderRequest request,
            @RequestHeader(value = "UserId",required = false) String userId) {
        System.out.println(userId);
        service.createOrder(request,getLong(userId));
    }
}
