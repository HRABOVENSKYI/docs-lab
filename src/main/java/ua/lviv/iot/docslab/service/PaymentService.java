package ua.lviv.iot.docslab.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.lviv.iot.docslab.dto.PaymentDto;
import ua.lviv.iot.docslab.model.Payment;
import ua.lviv.iot.docslab.repositiry.PaymentDao;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentDao paymentDao;
    private final OrderService orderService;

    public List<Payment> findAll() {
        return paymentDao.findAll();
    }

    public Payment findById(Long id) {
        return paymentDao.findById(id)
                .orElseThrow(() -> new RuntimeException("InsuranceResponse not found"));
    }

    public Payment create(PaymentDto paymentDto) {
        final Long parentPaymentId = paymentDto.getParentPaymentId();
        Payment payment = new Payment(
                orderService.findById(paymentDto.getOrderId()),
                paymentDto.getPaymentType(),
                Objects.isNull(parentPaymentId) ? null : findById(parentPaymentId)
        );
        return paymentDao.save(payment);
    }
}
