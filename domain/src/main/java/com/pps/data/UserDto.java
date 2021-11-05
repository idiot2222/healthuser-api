package com.pps.data;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class UserDto {

    private Long id;

    private String name;
    private String username;
    private String password;
    private String email;
    private Date birthDate;
    private Gender gender;

    private List<Long> userOwnCourses;

}
