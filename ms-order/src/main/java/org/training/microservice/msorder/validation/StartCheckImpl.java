package org.training.microservice.msorder.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StartCheckImpl implements ConstraintValidator<StartCheck,String> {

    private StartCheck anno;

    @Override
    public void initialize(StartCheck anno) {
        this.anno = anno;
    }

    @Override
    public boolean isValid(String value,
                           ConstraintValidatorContext context) {
        return value.startsWith(anno.value());
    }
}
