package com.pps.entity;

import com.pps.data.Gender;
import com.pps.data.UserDto;
import com.pps.data.UserRole;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String username;
    private String password;
    private String email;
    private Date birthDate;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    @OneToMany(mappedBy = "user")
    private final List<UserOwnCourse> userOwnCourses = new ArrayList<>();

    @Builder
    public User(Long id, String name, String username, String password, String email, Date birthDate, Gender gender, UserRole userRole) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.birthDate = birthDate;
        this.gender = gender;
        this.userRole = userRole;
    }

    public UserDto convertToUserDto() {
        UserDto userDto = new UserDto();

        List<Long> courseList = userOwnCourses.stream()
                .map(UserOwnCourse::UserOwnCourseToLong)
                .collect(Collectors.toList());

        userDto.setId(id);
        userDto.setName(name);
        userDto.setUsername(username);
        userDto.setPassword(password);
        userDto.setEmail(email);
        userDto.setBirthDate(birthDate);
        userDto.setGender(gender);
        userDto.setUserRole(userRole);
        userDto.setUserOwnCourses(courseList);

        return userDto;
    }
}
