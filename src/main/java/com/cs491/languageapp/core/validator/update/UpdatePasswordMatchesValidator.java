package com.cs491.languageapp.core.validator.update;



import com.cs491.languageapp.entity.request.UpdateOccupantRequest;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UpdatePasswordMatchesValidator implements ConstraintValidator<UpdatePasswordMatches, Object> {

    @Override
    public void initialize(UpdatePasswordMatches constraintAnnotation) {
    }
    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context){
        UpdateOccupantRequest customer = ( UpdateOccupantRequest) obj;
        return customer.getPassword().equals(customer.getMatchingPassword());
    }


}
