package ua.lviv.iot.docslab.service.strategy;

import ua.lviv.iot.docslab.dto.OrderDto;

public interface WriteStrategy {
    String write(OrderDto orderDto);
}
