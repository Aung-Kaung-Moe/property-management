package com.mycompanyapp.property_management.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import com.mycompanyapp.property_management.dto.UserDTO;
import com.mycompanyapp.property_management.repository.UserRepository;
import com.mycompanyapp.property_management.service.UserService;
import com.mycompanyapp.property_management.converter.UserConverter;
import com.mycompanyapp.property_management.entity.UserEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userConverter;

    @Override
    public UserDTO register(UserDTO userDto) {
        UserEntity userEntity = userConverter.dtoToEntity(userDto);
        userEntity = userRepository.save(userEntity);
        UserDTO savedUserDto = userConverter.entityToDto(userEntity);
        return savedUserDto;
    }

    @Override
    public UserDTO login(String email, String password) {
        return null;
    }   
}
