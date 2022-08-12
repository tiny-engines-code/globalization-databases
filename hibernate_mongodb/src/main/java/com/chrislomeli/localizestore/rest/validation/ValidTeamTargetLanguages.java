package com.chrislomeli.localizestore.rest.validation;

import com.chrislomeli.localizestore.exception.ErrorCodeImpl;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidTeamTargetLanguagesValidator.class)
public @interface ValidTeamTargetLanguages {
    // NOTE: message method required, but overridden by errorCode
    String message() default "{}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    ErrorCodeImpl errorCode() default ErrorCodeImpl.INVALID_TARGET_LANGUAGES;
}
