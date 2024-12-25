package az.msorderservice.client;

import az.msorderservice.client.decoder.CustomErrorDecoder;
import az.msorderservice.model.request.PaymentRequest;
import az.msorderservice.model.response.PaymentResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@FeignClient(
        name = "ms-payment-service",
        url = "http://localhost:8083/v1/api/payments",
        configuration = CustomErrorDecoder.class)
public interface PaymentClient {
    @PostMapping
    void createPayment(@RequestBody PaymentRequest request);

    @GetMapping("order/{orderId}")
    PaymentResponse getPaymentByOrderId(@PathVariable Long orderId);
}
