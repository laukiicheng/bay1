package com.card.models;

import javax.validation.constraints.*;
import java.time.LocalDate;

public class Transaction {

    public Transaction(
            int messageType,
            String creditCardNumber,
            LocalDate expirationDate,
            int transactionAmountInCents,
            String responseCode,
            String cardHolderName,
            String zipCode
    ) {
        this.messageType = messageType;
        this.creditCardNumber = creditCardNumber;
        this.expirationDate = expirationDate;
        this.transactionAmountInCents = transactionAmountInCents;
        this.responseCode = responseCode;
        this.cardHolderName = cardHolderName;
        this.zipCode = zipCode;
    }

    @NotNull
    @Size(min = 0, max = 4)
    public int messageType;

    @NotNull
    @Size(min = 0, max = 2)
    public int bitMap;

    @NotNull
    @NotBlank
    public String creditCardNumber;

    @NotNull
    public LocalDate expirationDate;

    @NotNull
    public int transactionAmountInCents;

    @NotNull
    @NotBlank
    @Min(2)
    @Max(2)
    public String responseCode;

    public String cardHolderName;

    public String zipCode;
}
