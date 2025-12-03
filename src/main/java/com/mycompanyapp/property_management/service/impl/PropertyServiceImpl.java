package com.mycompanyapp.property_management.service.impl;
import com.mycompanyapp.property_management.dto.PropertyDTO;
import com.mycompanyapp.property_management.repository.PropertyRepository;
import com.mycompanyapp.property_management.service.PropertyService;

import com.mycompanyapp.property_management.entity.PropertyEntity;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mycompanyapp.property_management.converter.PropertyConverter;

@Service
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;
    @Autowired
    private PropertyConverter propertyConverter;

    @Override
    public PropertyDTO saveProperty(PropertyDTO propertyDTO) {
        PropertyEntity pe = propertyConverter.dtoToEntity(propertyDTO);
        pe = propertyRepository.save(pe);

        propertyDTO = propertyConverter.entityToDto(pe);
        return propertyDTO;
    }

    @Override
    public List<PropertyDTO> getAllProperties() {
        List<PropertyEntity> propEntity = (List<PropertyEntity>) propertyRepository.findAll();
        List<PropertyDTO> propertyDTOs = new ArrayList<>();

        for (PropertyEntity entity : propEntity) {
            PropertyDTO dto = propertyConverter.entityToDto(entity);
            propertyDTOs.add(dto);
        }
        return propertyDTOs;
    }
    
    @Override
    public PropertyDTO updateProperty(PropertyDTO propertyDTO, Long propertyId) {
        Optional<PropertyEntity> optionalEntity = propertyRepository.findById(propertyId);
        if (optionalEntity.isPresent()) {
            PropertyEntity existingEntity = optionalEntity.get();
            existingEntity.setTitle(propertyDTO.getTitle());
            existingEntity.setDescription(propertyDTO.getDescription());
            existingEntity.setOwnerName(propertyDTO.getOwnerName());
            existingEntity.setOwnerEmail(propertyDTO.getOwnerEmail());
            existingEntity.setPrice(propertyDTO.getPrice());
            existingEntity.setAddress(propertyDTO.getAddress());

            PropertyEntity updatedEntity = propertyRepository.save(existingEntity);
            return propertyConverter.entityToDto(updatedEntity);
        }
        return null;
    }

    @Override
    public PropertyDTO updatePropertyDescription(PropertyDTO propertyDTO, Long propertyId) {
        Optional<PropertyEntity> optionalEntity = propertyRepository.findById(propertyId);
        if (optionalEntity.isPresent()) {
            PropertyEntity existingEntity = optionalEntity.get();
            existingEntity.setDescription(propertyDTO.getDescription());

            PropertyEntity updatedEntity = propertyRepository.save(existingEntity);
            return propertyConverter.entityToDto(updatedEntity);
        }
        return null;
    }

    @Override
    public PropertyDTO updatePropertyPrice(PropertyDTO propertyDTO, Long propertyId) {
        Optional<PropertyEntity> optionalEntity = propertyRepository.findById(propertyId);
        if (optionalEntity.isPresent()) {
            PropertyEntity existingEntity = optionalEntity.get();
            existingEntity.setPrice(propertyDTO.getPrice());

            PropertyEntity updatedEntity = propertyRepository.save(existingEntity);
            return propertyConverter.entityToDto(updatedEntity);
        }
        return null;
    }

    @Override
    public void deleteProperty(Long propertyId) {
        propertyRepository.deleteById(propertyId);
    }
}