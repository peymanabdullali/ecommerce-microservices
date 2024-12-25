package az.mspaymentservice.service.impl;

import az.mspaymentservice.dao.entity.PaymentEntity;
import az.mspaymentservice.dao.repository.PaymentRepository;
import az.mspaymentservice.exception.NotFoundException;
import az.mspaymentservice.mapper.PaymentMapper;
import az.mspaymentservice.model.request.PaymentRequest;
import az.mspaymentservice.model.response.PaymentResponse;
import az.mspaymentservice.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static az.mspaymentservice.enums.Messages.PAYMENT_NOT_FOUND;
import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository repository;
    private final PaymentMapper mapper;

    @Override
    public void createPayment(PaymentRequest request) {
        repository.save(mapper.mapToEntity(request));
    }

    @Override
    public PaymentResponse getPaymentByOrderId(Long orderId) {
        return mapper.mapToResponse(repository.findByOrderId(orderId).
                orElseThrow(() ->
                        new NotFoundException(format(PAYMENT_NOT_FOUND.getMessage(), orderId))
                )
        );
    }
}
