package com.example.payment.controller;

import com.example.payment.dto.ModifyUserDto;
import com.example.payment.dto.RegisterUserDto;
import com.example.payment.entity.User;
import com.example.payment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MemberController {
    @Autowired
    UserService userService;

    @PostMapping("/member/users/registration")
    public User registerUser(@RequestBody RegisterUserDto dto) {
        return userService.registerUser(dto.loginId, dto.userName);
    }

    @PutMapping("/member/users/{userId}/modify")
    public User modifyUser(@PathVariable Long userId, @RequestBody ModifyUserDto dto) {
        return userService.modifyUser(userId, dto.userName);
    }

    @PostMapping ("/member/users/{loginId}/login")
    public User login(@PathVariable String loginId) {
        return userService.getUser(loginId);
    }
}
