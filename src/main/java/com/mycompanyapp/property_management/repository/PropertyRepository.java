package com.mycompanyapp.property_management.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mycompanyapp.property_management.entity.PropertyEntity;

@Repository
public interface PropertyRepository extends CrudRepository<PropertyEntity, Long> {
    
}
