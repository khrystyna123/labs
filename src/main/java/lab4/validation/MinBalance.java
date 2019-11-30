package lab4.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Constraint(validatedBy = MinBalanceValidator.class)
public @interface MinBalance {
    double value();

    String message() default "{MinBalance}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
