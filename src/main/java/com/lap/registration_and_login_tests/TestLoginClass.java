package com.lap.registration_and_login_tests;

import com.lap.dao.impl.UserDaoImpl;
import com.lap.entity.User;

import java.util.List;

public class TestLoginClass {
    // переделать.

    public String testLoginMethod(String testuserlogin, String testuserpassword) {
        List<User> allUsers = UserDaoImpl.getInstance().findAll();
        int flag = 0;
        for (User user : allUsers) {
            if (user.getLogin().equals(testuserlogin) && user.getPassword().equals(testuserpassword)) {
                flag++;
            }
        }
        if (flag == 0) {
            return "failed";
        } else {
            return "success";
        }
    }
}