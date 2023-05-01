package ua.lviv.iot.docslab.service.strategy;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ua.lviv.iot.docslab.dto.OrderDto;
import ua.lviv.iot.docslab.mapper.OrderMapper;
import ua.lviv.iot.docslab.model.Order;
import ua.lviv.iot.docslab.repositiry.OrderDao;

@Service
@RequiredArgsConstructor
@Slf4j
public class WriteToDbStrategy implements WriteStrategy {
    private final OrderDao orderDao;
    private final OrderMapper orderMapper;

    @Override
    public String write(OrderDto orderDto) {
        final Order order = orderDao.save(orderMapper.map(orderDto));
        log.info(order.toString());
        return "Wrote to DB successfully";
    }
}
