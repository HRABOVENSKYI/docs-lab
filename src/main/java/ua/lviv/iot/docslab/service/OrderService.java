package ua.lviv.iot.docslab.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.lviv.iot.docslab.model.Order;
import ua.lviv.iot.docslab.repositiry.OrderDao;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderDao orderDao;

    public List<Order> findAll() {
        return orderDao.findAll();
    }

    public Order findById(Long id) {
        return orderDao.findById(id)
                .orElseThrow(() -> new RuntimeException("InsuranceResponse not found"));
    }
}
