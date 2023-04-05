package ua.lviv.iot.docslab.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.lviv.iot.docslab.model.Insurance;
import ua.lviv.iot.docslab.repositiry.InsuranceDao;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InsuranceService {

    private final InsuranceDao insuranceDao;

    public List<Insurance> findAll() {
        return insuranceDao.findAll();
    }

    public Insurance findById(Long id) {
        return insuranceDao.findById(id)
                .orElseThrow(() -> new RuntimeException("Insurance not found"));
    }
}
