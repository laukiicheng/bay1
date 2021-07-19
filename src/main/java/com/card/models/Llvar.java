package com.card.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class Llvar {

    public Llvar(String value){
        this.value = value;
    }

    // variable length
    // two section
    // first 2 chars numeric indication the length of the actual alpha value
    // example 04CITY
    // TODO: Custom validator for length of actual value
    @NotNull
    @NotBlank
    @Pattern(regexp = "^[0-9]{2}[a-zA-Z]+$", message = "Invalid value for alpha type data")
    public String value;
}
