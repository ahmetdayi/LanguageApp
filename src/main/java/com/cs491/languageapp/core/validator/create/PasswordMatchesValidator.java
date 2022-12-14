package com.cs491.languageapp.core.validator.create;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.cs491.languageapp.entity.request.CreateOccupantRequest;


public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
    }
    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context){
        CreateOccupantRequest customer = ( CreateOccupantRequest) obj;
        return customer.getPassword().equals(customer.getMatchingPassword());
    }


}