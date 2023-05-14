package ua.lviv.iot.docslab.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.lviv.iot.docslab.dto.OrderCsvDto;
import ua.lviv.iot.docslab.model.Order;
import ua.lviv.iot.docslab.service.OrderService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        return ResponseEntity.ok(orderService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrder(@PathVariable("id") Long id) {
        return ResponseEntity.ok(orderService.findById(id));
    }

    @PostMapping("/generate-csv")
    public ResponseEntity<List<OrderCsvDto>> createOrdersCsv() {
        return ResponseEntity.ok(orderService.generateOrdersCsv());
    }

    @PostMapping("/save-csv-to-db")
    public ResponseEntity<List<Order>> saveCsvToDb() {
        return ResponseEntity.ok(orderService.saveCsvToDb());
    }
}
