package ua.lviv.iot.docslab.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.lviv.iot.docslab.enums.PaymentType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "cost")
    private BigDecimal cost;

    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @Column(name = "transaction_timestamp")
    private LocalDateTime transactionTimestamp;

    @Column(name = "payment_type")
    private PaymentType paymentType;

    @OneToOne
    @JoinColumn(name = "refund_transaction_id")
    private Payment parentPayment;

    public Payment(Order order, PaymentType paymentType, Payment parentPayment) {
        this.order = order;
        this.cost = order.getInsurance().getPrice();
        this.transactionTimestamp = LocalDateTime.now();
        this.paymentType = paymentType;
        this.parentPayment = parentPayment;
    }
}
