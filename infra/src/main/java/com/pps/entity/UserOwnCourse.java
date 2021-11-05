package com.pps.entity;

import javax.persistence.*;

@Entity
public class UserOwnCourse {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private User user;

    public Long UserOwnCourseToLong() {
        return id;
    }
}
