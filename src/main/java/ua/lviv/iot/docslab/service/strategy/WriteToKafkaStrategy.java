package ua.lviv.iot.docslab.service.strategy;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ua.lviv.iot.docslab.dto.OrderDto;

@Service
@RequiredArgsConstructor
public class WriteToKafkaStrategy implements WriteStrategy {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private static final ObjectMapper MAPPER = new ObjectMapper();

    @Value("${kafka.topic}")
    private String TOPIC_NAME;

    @Override
    public String write(OrderDto orderDto) {
        try {
            kafkaTemplate.send(TOPIC_NAME, MAPPER.writeValueAsString(orderDto));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "Wrote to Kafka successfully";
    }
}
