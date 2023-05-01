package ua.lviv.iot.docslab.service.strategy;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class WriteConfig {
    @Value("${write.type}")
    private String WRITE_TYPE;

    private final WriteToDbStrategy writeToDbStrategy;
    private final WriteToKafkaStrategy writeToKafkaStrategy;

    @Bean
    public WriteStrategy writeStrategy() {
        return switch (WRITE_TYPE) {
            case "KAFKA" -> writeToKafkaStrategy;
            case "DB" -> writeToDbStrategy;
            default -> throw new IllegalArgumentException(String.format("Invalid write.type property: %s", WRITE_TYPE));
        };
    }
}
