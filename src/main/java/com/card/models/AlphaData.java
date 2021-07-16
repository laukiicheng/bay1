package com.card.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class AlphaData {
    // fixed length n
    // 0-9a-zA-Z, spaces
    // right padded to n characters
    // example "CITY "
    @NotNull
    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Invalid value for alpha type data")
    public String value;
}


