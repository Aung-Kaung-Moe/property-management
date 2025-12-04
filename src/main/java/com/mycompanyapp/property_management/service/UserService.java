package com.mycompanyapp.property_management.service;
import com.mycompanyapp.property_management.dto.UserDTO;

public interface UserService {
    UserDTO register(UserDTO userDto);
    UserDTO login(String email, String password);
}
