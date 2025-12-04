package com.mycompanyapp.property_management.exception;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class BusinessException extends RuntimeException {

    List<ErrorModel> errors;
    public BusinessException() {
    }

    public BusinessException(List<ErrorModel> errors) {
        this.errors = errors;
    }

}
