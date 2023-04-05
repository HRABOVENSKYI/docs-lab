package ua.lviv.iot.docslab.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderCsvDto {
    private Long insuranceId;
    private Long userId;
    private LocalDateTime createdAt;
}
