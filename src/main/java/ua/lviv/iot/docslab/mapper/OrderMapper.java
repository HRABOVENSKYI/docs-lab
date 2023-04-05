package ua.lviv.iot.docslab.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ua.lviv.iot.docslab.dto.OrderCsvDto;
import ua.lviv.iot.docslab.dto.OrderDto;
import ua.lviv.iot.docslab.model.Order;
import ua.lviv.iot.docslab.service.InsuranceService;
import ua.lviv.iot.docslab.service.UserService;

@Component
@RequiredArgsConstructor
public class OrderMapper {

    private final UserService userService;
    private final InsuranceService insuranceService;

    public Order map(OrderCsvDto orderCsvDto) {
        return new Order(
                insuranceService.findById(orderCsvDto.getInsuranceId()),
                userService.findById(orderCsvDto.getUserId()),
                orderCsvDto.getCreatedAt()
        );
    }

    public Order map(OrderDto orderDto) {
        return new Order(
                insuranceService.findById(orderDto.getInsuranceId()),
                userService.findById(orderDto.getUserId())
        );
    }
}
