package com.mycompanyapp.property_management.converter;
import org.springframework.stereotype.Component;
import com.mycompanyapp.property_management.dto.UserDTO;
import com.mycompanyapp.property_management.entity.UserEntity;

@Component
public class UserConverter {
    public UserEntity dtoToEntity(UserDTO userDTO) {
        UserEntity ue = new UserEntity();
        ue.setId(userDTO.getId());
        ue.setOwnerName(userDTO.getOwnerName());
        ue.setOwnerEmail(userDTO.getOwnerEmail());
        ue.setPhone(userDTO.getPhone());
        ue.setPassword(userDTO.getPassword());
        return ue;
    }

    public UserDTO entityToDto(UserEntity userEntity) {
        UserDTO ud = new UserDTO();
        ud.setId(userEntity.getId());
        ud.setOwnerName(userEntity.getOwnerName());
        ud.setOwnerEmail(userEntity.getOwnerEmail());
        ud.setPhone(userEntity.getPhone());
        ud.setPassword(userEntity.getPassword());
        return ud;
    } 
}
