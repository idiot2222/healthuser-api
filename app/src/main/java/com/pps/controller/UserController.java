package com.pps.controller;

import com.pps.data.UserDto;
import com.pps.payload.UserUpdateDto;
import com.pps.ports.incoming.UserServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserServicePort userServicePort;

    @PostMapping("/create")
    public void createUser(@RequestBody UserDto userDto) {
        userServicePort.createUser(userDto);
    }

    @GetMapping("/info/{id}")
    public UserDto getUserById(@PathVariable Long id) {
        return userServicePort.getUserById(id);
    }

    @GetMapping("/list")
    public List<UserDto> getUserList() {
        return userServicePort.getAllUserList();
    }

    @PutMapping("/update/{id}")
    public void updateUser(@PathVariable Long id, @RequestBody UserUpdateDto updateDto) {
        UserDto user = userServicePort.getUserById(id);

        user.setPassword(updateDto.getPassword());
        user.setEmail(updateDto.getEmail());

        userServicePort.updateUser(user);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Long id) {
        userServicePort.deleteUser(id);
    }

}
