package com.example.payment.service;

import com.example.payment.entity.User;
import com.example.payment.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User registerUser(String loginId, String userName) {
        var user = new User(loginId, userName);
        return userRepository.save(user);
    }

    public User modifyUser(Long userId, String userName) {
        var user = userRepository.findById(userId).orElseThrow();
        user.userName = userName;

        return userRepository.save(user);
    }

    public User getUser(String loginId) {
        return userRepository.findByLoginId(loginId).orElseThrow();
    }
}
