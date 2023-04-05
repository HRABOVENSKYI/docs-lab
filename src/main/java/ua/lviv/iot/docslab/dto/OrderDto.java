package ua.lviv.iot.docslab.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderDto {
    private Long insuranceId;
    private Long userId;
}

