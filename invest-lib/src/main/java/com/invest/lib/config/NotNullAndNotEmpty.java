package com.invest.lib.config;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = StringValidator.class)
@Target( { ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface NotNullAndNotEmpty {
    String message() default "Empty or null field not accepted";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
