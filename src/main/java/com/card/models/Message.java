package com.card.models;

import javax.validation.constraints.*;
import java.util.List;

public class Message {
    // 4 digits
    // 0110
    // 0110
    @NotNull
    @Size(min = 0, max = 4)
    public int messageType;

    // 2 character
    // lower case, hex encoding of 1 byte bitmap value
    // c8 -> 11001000
    @NotNull
    @Size(min = 0, max = 2)
    public int bitMap;

    @NotNull
    // 14-19
    public Llvar creditCardNumber;

    @NotNull
    @NotBlank
    @Min(4)
    @Max(4)
    @Pattern(regexp = "^[0-9]{2}[0-9]{2}", message = "Invalid expiration date")
    public String expirationDate;

    @NotNull
    @NotBlank
    public String transactionAmountInCents;

    @NotNull
    @NotBlank
    @Min(2)
    @Max(2)
    public String responseCode;

    public String cardHolderName = "";

    @Pattern(regexp = "^}[0-9]{4}", message = "Invalid expiration date")
    public String zipCode = "";
}
