package com.pps.adapter;

import com.pps.data.UserDto;
import com.pps.entity.User;
import com.pps.ports.outgoing.UserPersistencePort;
import com.pps.repository.UserRepository;
import com.pps.util.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserJpaAdapter implements UserPersistencePort {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = userMapper.userDtoToUser(userDto);

        User savedUser = userRepository.save(user);

        return userMapper.userToUserDto(savedUser);
    }

    @Override
    public UserDto getUserById(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user id."));

        return userMapper.userToUserDto(user);
    }

    @Override
    public List<UserDto> getAllUserList() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::userToUserDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        return createUser(userDto);
    }

    @Override
    public void deleteUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user id."));

        userRepository.delete(user);
    }
}
