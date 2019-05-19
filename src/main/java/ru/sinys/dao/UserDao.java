package ru.sinys.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sinys.model.User;

public interface UserDao extends JpaRepository<User, Long> {
    User findByUsername(String Username);
}
