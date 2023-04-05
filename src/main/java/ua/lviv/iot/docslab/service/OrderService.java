package ua.lviv.iot.docslab.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.lviv.iot.docslab.dto.OrderDto;
import ua.lviv.iot.docslab.model.Order;
import ua.lviv.iot.docslab.repositiry.OrderDao;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderDao orderDao;
    private final UserService userService;
    private final InsuranceService insuranceService;

    public List<Order> findAll() {
        return orderDao.findAll();
    }

    public Order findById(Long id) {
        return orderDao.findById(id)
                .orElseThrow(() -> new RuntimeException("InsuranceResponse not found"));
    }

    public Order create(OrderDto orderDto) {
        Order order = new Order(
                insuranceService.findById(orderDto.getInsuranceId()),
                userService.findById(orderDto.getUserId())
        );
        return orderDao.save(order);
    }
}
