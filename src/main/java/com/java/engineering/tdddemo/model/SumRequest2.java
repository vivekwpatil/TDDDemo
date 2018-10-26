package com.java.engineering.tdddemo.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

public class SumRequest2 implements Serializable {
    @NotNull(message = "must not be null")
    @Pattern( regexp = "^0*([0-9]|[1-8][0-9]|9[0-9]|[1-8][0-9]{2}|9[0-8][0-9]|99[0-9])$", message = "Size must be between 0 and 999")
    private String number1;
    @NotNull(message = "must not be null")
    private String number2;

    public SumRequest2() {

    }

    public SumRequest2(String number1, String number2) {
        this.number1 = number1;
        this.number2 = number2;
    }

    public String getNumber1() {
        return number1;
    }

    public String getNumber2() {
        return number2;
    }
}
