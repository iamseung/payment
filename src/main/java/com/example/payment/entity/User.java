package com.example.payment.entity;

import jakarta.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(unique = true)
    public String loginId;
    public String userName;

    public User() {
    }

    public User(String loginId, String userName) {
        this.loginId = loginId;
        this.userName = userName;
    }
}
