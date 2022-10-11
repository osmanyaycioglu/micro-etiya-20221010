package org.training.microservice.msorder.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.FIELD})
@Constraint(validatedBy = { StartCheckImpl.class })
public @interface StartCheck {

    String value();

    String message() default "{javax.validation.constraints.StartCheck.message}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}
