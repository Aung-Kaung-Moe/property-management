package com.mycompanyapp.property_management.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import com.mycompanyapp.property_management.dto.UserDTO;
import com.mycompanyapp.property_management.repository.UserRepository;
import com.mycompanyapp.property_management.service.UserService;
import com.mycompanyapp.property_management.converter.UserConverter;
import com.mycompanyapp.property_management.entity.UserEntity;
import org.springframework.stereotype.Service;
import java.util.*;
import com.mycompanyapp.property_management.exception.ErrorModel;
import com.mycompanyapp.property_management.exception.BusinessException;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userConverter;

    @Override
    public UserDTO register(UserDTO userDto) {
        Optional<UserEntity> optionalUserEntity = userRepository.findByOwnerEmail(userDto.getOwnerEmail());
        if(optionalUserEntity.isPresent()) {
            List<ErrorModel> errorList = new ArrayList<>();
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("400");
            errorModel.setMessage("Email already registered");
            errorList.add(errorModel);
            throw new BusinessException(errorList);
        }
        
        UserEntity userEntity = userConverter.dtoToEntity(userDto);
        userEntity = userRepository.save(userEntity);
        UserDTO savedUserDto = userConverter.entityToDto(userEntity);
        return savedUserDto;
    }

    @Override
    public UserDTO login(String email, String password) {
        UserDTO userDto = null;
        Optional<UserEntity> optionalUserEntity = userRepository.findByOwnerEmailAndPassword(email, password);
        if(optionalUserEntity.isPresent()) {
            userDto = userConverter.entityToDto(optionalUserEntity.get());
        } else {
            List<ErrorModel> errorList = new ArrayList<>();
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("401");
            errorModel.setMessage("Invalid email or password");
            errorList.add(errorModel);
            throw new BusinessException(errorList);
        }
        return userDto;
    }   
}
