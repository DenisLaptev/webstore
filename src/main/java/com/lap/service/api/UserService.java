package com.lap.service.api;


import com.lap.dto.UserDto;

import java.util.List;

/**
 * Created by Kovantonlenko on 6/16/2016.
 */
public interface UserService {

    List<UserDto> getAllUsers();

    UserDto getUserById(long id);

    void createUser(UserDto userDto);

    boolean deleteUser(long id);
}
