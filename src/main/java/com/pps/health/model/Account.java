package com.pps.health.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;
    private String password;
    private String email;
    private String name;
    private int height;
    private int weight;
    private Date birthDate;

    @Enumerated(EnumType.STRING)
    private Gender gender;

}
