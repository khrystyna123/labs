package lab4.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MinBalanceValidator implements ConstraintValidator<MinBalance, Double> {

    private double annotationMinBalance;

    @Override
    public void initialize(MinBalance minBalance) {
        this.annotationMinBalance = minBalance.value();
    }

    @Override
    public boolean isValid(Double aDouble, ConstraintValidatorContext constraintValidatorContext) {
        if(aDouble>= annotationMinBalance)
            return true;
        else {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate("must be more than " + annotationMinBalance)
                    .addConstraintViolation();
            return false;
        }
    }
}