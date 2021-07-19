package com.services;

import com.card.models.Message;
import com.card.models.Transaction;

import java.time.LocalDate;

public class TransactionService {

    public Transaction getTransaction(Message message) {
        return new Transaction(
                Integer.parseInt(message.messageType),
                message.creditCardNumber,
                LocalDate.parse(message.expirationDate),
                Integer.parseInt(message.transactionAmountInCents),
                message.responseCode,
                message.cardHolderName,
                message.zipCode
        );
    }
}
