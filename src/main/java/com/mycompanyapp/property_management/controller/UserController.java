package com.mycompanyapp.property_management.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import com.mycompanyapp.property_management.dto.UserDTO;
import com.mycompanyapp.property_management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserDTO> register(@RequestBody UserDTO userDto) {
        UserDTO registeredUser = userService.register(userDto);
        ResponseEntity<UserDTO> response = new ResponseEntity<>(registeredUser, HttpStatus.CREATED);
        return response;
    }
}
