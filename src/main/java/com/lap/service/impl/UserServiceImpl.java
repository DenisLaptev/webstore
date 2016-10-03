package com.lap.service.impl;


import com.lap.dao.api.UserDao;
import com.lap.dao.impl.UserDaoImpl;
import com.lap.dto.UserDto;
import com.lap.entity.User;
import com.lap.helper.TransformerUser;
import com.lap.service.api.UserService;

import javax.xml.transform.Transformer;
import java.util.List;

/**
 * Created by Kovantonlenko on 6/16/2016.
 */
public class UserServiceImpl implements UserService {

    private static UserService userService;
    private UserDao userDao;

    private UserServiceImpl() {
        userDao = UserDaoImpl.getInstance();
    }

    public static UserService getInstance() {
        if (userService == null) {
            synchronized (UserServiceImpl.class) {
                if (userService == null) {
                    userService = new UserServiceImpl();
                }
            }
        }
        return userService;
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userDao.findAll();
        List<UserDto> userDtos = TransformerUser.transformListUserToUserDTO(users);
        return userDtos;
    }

    @Override
    public UserDto getUserById(long id) {
        //todo add implementation
        UserDto userDto = new UserDto();
        userDto.setId(id);
        return userDto;
    }

    @Override
    public void createUser(UserDto userDto) {
        //todo add implementation
    }

    @Override
    public boolean deleteUser(long id) {
        //todo add implementation
        return true;
    }
}
