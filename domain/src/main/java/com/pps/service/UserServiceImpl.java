package com.pps.service;

import com.pps.data.UserDto;
import com.pps.ports.incoming.UserServicePort;
import com.pps.ports.outgoing.UserPersistencePort;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class UserServiceImpl implements UserServicePort {

    private final UserPersistencePort userPersistencePort;

    @Override
    public UserDto createUser(UserDto userDto) {
        return userPersistencePort.createUser(userDto);
    }

    @Override
    public UserDto getUserById(Long userId) {
        return userPersistencePort.getUserById(userId);
    }

    @Override
    public List<UserDto> getAllUserList() {
        return userPersistencePort.getAllUserList();
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        return userPersistencePort.updateUser(userDto);
    }

    @Override
    public void deleteUser(Long userId) {
        userPersistencePort.deleteUser(userId);
    }
}
