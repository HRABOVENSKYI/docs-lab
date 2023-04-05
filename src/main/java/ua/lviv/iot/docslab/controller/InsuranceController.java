package ua.lviv.iot.docslab.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.lviv.iot.docslab.model.Insurance;
import ua.lviv.iot.docslab.service.InsuranceService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/insurance")
public class InsuranceController {

    private final InsuranceService insuranceService;

    @GetMapping
    public ResponseEntity<List<Insurance>> getAllInsurances() {
        return ResponseEntity.ok(insuranceService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Insurance> getInsurance(@PathVariable("id") Long id) {
        return ResponseEntity.ok(insuranceService.findById(id));
    }
}
