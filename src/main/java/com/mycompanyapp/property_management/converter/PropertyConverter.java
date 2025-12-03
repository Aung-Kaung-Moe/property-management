package com.mycompanyapp.property_management.converter;
import org.springframework.stereotype.Component;

import com.mycompanyapp.property_management.dto.PropertyDTO;
import com.mycompanyapp.property_management.entity.PropertyEntity;

@Component
public class PropertyConverter {
    public PropertyEntity dtoToEntity(PropertyDTO propertyDTO) {
        PropertyEntity pe = new PropertyEntity();
        pe.setId(propertyDTO.getId());
        pe.setTitle(propertyDTO.getTitle());
        pe.setDescription(propertyDTO.getDescription());
        pe.setOwnerName(propertyDTO.getOwnerName());
        pe.setOwnerEmail(propertyDTO.getOwnerEmail());
        pe.setPrice(propertyDTO.getPrice());
        pe.setAddress(propertyDTO.getAddress());
        return pe;
    }

    public PropertyDTO entityToDto(PropertyEntity propertyEntity) {
        PropertyDTO pd = new PropertyDTO();
        pd.setId(propertyEntity.getId());
        pd.setTitle(propertyEntity.getTitle());
        pd.setDescription(propertyEntity.getDescription());
        pd.setOwnerName(propertyEntity.getOwnerName());
        pd.setOwnerEmail(propertyEntity.getOwnerEmail());
        pd.setPrice(propertyEntity.getPrice());
        pd.setAddress(propertyEntity.getAddress());
        return pd;
    }
}
