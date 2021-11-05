package com.pps.ports.incoming;

import com.pps.data.UserDto;

import java.util.List;

public interface UserServicePort {

    UserDto createUser(UserDto userDto);

    UserDto getUserById(Long userId);

    List<UserDto> getAllUserList();

    UserDto updateUser(UserDto userDto);

    void deleteUser(Long userId);

}
