package ua.lviv.iot.docslab.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.lviv.iot.docslab.model.User;
import ua.lviv.iot.docslab.repositiry.UserDao;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserDao userDao;

    public List<User> findAll() {
        return userDao.findAll();
    }

    public User findById(Long id) {
        return userDao.findById(id)
                .orElseThrow(() -> new RuntimeException("InsuranceResponse not found"));
    }
}
