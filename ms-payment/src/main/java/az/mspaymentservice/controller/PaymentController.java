package az.mspaymentservice.controller;

import az.mspaymentservice.model.request.PaymentRequest;
import az.mspaymentservice.model.response.PaymentResponse;
import az.mspaymentservice.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("v1/api/payments")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService service;

    @PostMapping
    @ResponseStatus(CREATED)
    public void createPayment(@RequestBody PaymentRequest request) {
        service.createPayment(request);
    }

    @GetMapping("order/{orderId}")
    public PaymentResponse getPaymentByOrderId(@PathVariable Long orderId) {
      return   service.getPaymentByOrderId(orderId);
    }
}
