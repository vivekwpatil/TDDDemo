package com.java.engineering.tdddemo;

import com.java.engineering.tdddemo.model.SumRequest2;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class SumRequest2Test {

    private static Validator validator;

    @BeforeClass
    public static void setUpValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void giveNullnnumbersThenResponseValidationError() {
        SumRequest2 request = new SumRequest2();

        Set<ConstraintViolation<SumRequest2>> constraintViolations =
            validator.validate(request);

        assertEquals(2, constraintViolations.size());
        assertEquals("must not be null", constraintViolations.iterator().next().getMessage());
    }

    @Test
    public void givennumberWithExcedingSizeThenResponseValidationError() {
        SumRequest2 request = new SumRequest2("3333", "10");

        Set<ConstraintViolation<SumRequest2>> constraintViolations =
            validator.validate(request);

        assertEquals(1, constraintViolations.size());
        assertEquals("Size must be between 0 and 999", constraintViolations.iterator().next().getMessage());
    }

    @Test
    public void givenWithNegativeNumbersThenResponseValidationError() {
        SumRequest2 request = new SumRequest2("-3", "10");

        Set<ConstraintViolation<SumRequest2>> constraintViolations =
            validator.validate(request);

        assertEquals(1, constraintViolations.size());
        assertEquals("Size must be between 0 and 999", constraintViolations.iterator().next().getMessage());
    }

}

