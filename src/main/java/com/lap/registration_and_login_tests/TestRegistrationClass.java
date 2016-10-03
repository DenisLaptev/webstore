package com.lap.registration_and_login_tests;

import com.lap.dao.impl.UserDaoImpl;
import com.lap.entity.User;

import java.util.List;

public class TestRegistrationClass {
// Метод testRegistrationMethod(String testuserlogin) проверяет, есть ли
// в БД юзеры с логином testuserlogin.
// Если нет, то возвращает значение "unknown",
// если такой логин есть, то "known".
    public String testRegistrationMethod(String testuserlogin) {
        List<User> allUsers = UserDaoImpl.getInstance().findAll();
        int flag = 0;
        for (User user : allUsers) {
            if (user.getLogin().equals(testuserlogin)) {
                flag++;
            }
        }
        if (flag == 0) {
            return "unknown";
        } else {
            return "known";
        }
    }
}