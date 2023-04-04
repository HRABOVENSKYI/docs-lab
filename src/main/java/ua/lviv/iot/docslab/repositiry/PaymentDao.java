package ua.lviv.iot.docslab.repositiry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.docslab.model.Payment;

@Repository
public interface PaymentDao extends JpaRepository<Payment, Long> {
}
