package com.card.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class NumericData {
    // fixed length n
    // 0-9 characters
    // lef padded to n character with 0's
    // example "000010"
    @NotNull
    @NotBlank
    public String value;
}
