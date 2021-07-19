package com.card.models;

import javax.validation.constraints.*;

public class Message {

    public Message(){}

    public Message(
            String messageType,
            String creditCardNumber,
            String transactionAmountInCents,
            String expirationDate,
            String responseCode,
            String cardHolderName,
            String zipCode
    ) {
        this.messageType = messageType;
        this.creditCardNumber = creditCardNumber;
        this.transactionAmountInCents = transactionAmountInCents;
        this.expirationDate = expirationDate;
        this.responseCode = responseCode;
        this.cardHolderName = cardHolderName;
        this.zipCode = zipCode;
    }

    // 4 digits
    // 0110
    // 0110

    public String messageType;

    @NotNull
    // 14-19
    public String creditCardNumber;

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
