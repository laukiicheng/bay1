package com.services;

import com.Application;
import com.card.models.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.Valid;
import java.time.LocalDate;

//@Component
public class CardAuthService {

    @Autowired
    private Logger logger;

    public Boolean authorizeCard(@Valid Transaction transaction) {
        int transactionAmountInDollars = transaction.transactionAmountInCents / 100;

        if (transaction.zipCode != null && transactionAmountInDollars >= 200) {
            return false;
        }

        if (transaction.zipCode == null && transactionAmountInDollars >= 100) {
            return false;
        }

        if (transaction.expirationDate.isAfter(LocalDate.now())) {
            return false;
        }

        return true;
    }

    public void getPrintTransactionIsValid(Boolean transactionValid, String transaction, String responseCode){
        if(transactionValid){
            logger.info(transaction + responseCode);
        }else{
            logger.info(transaction + "DE");
        }
    }

    public void printTransactionMissingRequiredField(String transaction){
        logger.info(transaction + "ER");
    }
}
