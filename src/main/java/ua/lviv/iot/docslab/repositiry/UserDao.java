package ua.lviv.iot.docslab.repositiry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.docslab.model.User;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
}
