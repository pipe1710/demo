package com.example.demo.user.controller;

import com.example.demo.category.entity.Category;
import com.example.demo.user.dto.UserRequest;
import com.example.demo.user.entity.User;
import com.example.demo.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("api/user")
    public ResponseEntity<?> save(@RequestBody UserRequest userRequest) {
        try {
            User userCreate = this.userService.save(userRequest);
            return new ResponseEntity<>(userCreate, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
