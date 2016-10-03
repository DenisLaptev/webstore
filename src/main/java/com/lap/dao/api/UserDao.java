package com.lap.dao.api;

import com.lap.entity.User;

import java.sql.SQLException;
import java.util.List;


public interface UserDao {
    List<User> findAll();

    User findById(long id);

    void delete(long id);

    boolean create(User user);

    User findByLogin(String login);

    User findByLoginAndPassword(String login, String password);
}
