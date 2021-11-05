package com.pps.util;

import com.pps.data.UserDto;
import com.pps.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User userDtoToUser(UserDto userDto) {
        return User.builder()
                .id(userDto.getId())
                .name(userDto.getName())
                .username(userDto.getUsername())
                .password(userDto.getPassword())
                .email(userDto.getEmail())
                .birthDate(userDto.getBirthDate())
                .gender(userDto.getGender())
                .userRole(userDto.getUserRole())
                .build();
    }

    public UserDto userToUserDto(User savedUser) {
        return savedUser.convertToUserDto();
    }
}
