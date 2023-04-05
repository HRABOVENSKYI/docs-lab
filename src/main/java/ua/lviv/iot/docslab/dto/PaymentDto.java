package ua.lviv.iot.docslab.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import ua.lviv.iot.docslab.enums.PaymentType;

@Data
@AllArgsConstructor
public class PaymentDto {
    private Long orderId;
    private PaymentType paymentType;
    private Long parentPaymentId;
}
