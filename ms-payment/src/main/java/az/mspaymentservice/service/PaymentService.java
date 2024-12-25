package az.mspaymentservice.service;

import az.mspaymentservice.model.request.PaymentRequest;
import az.mspaymentservice.model.response.PaymentResponse;

public interface PaymentService {
    void createPayment(PaymentRequest request);
    PaymentResponse getPaymentByOrderId(Long orderId);

}
