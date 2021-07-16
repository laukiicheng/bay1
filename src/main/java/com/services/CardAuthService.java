package com.services;

import com.card.models.Message;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import java.time.LocalDate;

//@Component
public class CardAuthService {
    public Boolean authorizeCard(@Valid Message transaction) {
        int transactionAmountInCent = Integer.parseInt(transaction.transactionAmountInCents);
        int transactionAmountInDollars = transactionAmountInCent / 100;

        if (transaction.zipCode != null && transactionAmountInDollars >= 200) {
            return false;
        }

        if (transaction.zipCode == null && transactionAmountInDollars >= 100) {
            return false;
        }

        LocalDate expirationDate = LocalDate.parse(transaction.expirationDate);
        if (expirationDate.isAfter(LocalDate.now())) {
            return false;
        }

        return true;
    }
}
