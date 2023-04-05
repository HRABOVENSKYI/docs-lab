package ua.lviv.iot.docslab.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.lviv.iot.docslab.model.Payment;
import ua.lviv.iot.docslab.repositiry.PaymentDao;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentDao paymentDao;

    public List<Payment> findAll() {
        return paymentDao.findAll();
    }

    public Payment findById(Long id) {
        return paymentDao.findById(id)
                .orElseThrow(() -> new RuntimeException("InsuranceResponse not found"));
    }
}
