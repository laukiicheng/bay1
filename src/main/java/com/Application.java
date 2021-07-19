package com;

import com.card.models.Message;
import com.card.models.Transaction;
import com.services.CardAuthService;
import com.services.MessageService;
import com.services.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.List;
import java.util.Locale;

//@SpringBootApplication
//public class Application {
//	public static void main(String[] args) {
//		SpringApplication.run(Application.class, args);
//	}
//}

@SpringBootApplication
public class Application implements CommandLineRunner {

    private static Logger logger = LoggerFactory.getLogger(Application.class);
    private static CardAuthService cardAuthService = new CardAuthService();
    private static MessageService messageService = new MessageService();
    private static TransactionService transactionService = new TransactionService();


    public static void main(String[] args) {
        logger.info("STARTING THE APPLICATION");
        SpringApplication.run(Application.class, args);
        logger.info("APPLICATION FINISHED");
    }

    @Override
    public void run(String... args) {
        logger.info("EXECUTING : command line runner");

        String transactionsAsInput = "";
        for (String consoleArgument : args) {
            String[] keyValue = consoleArgument.split("=");
            String key = keyValue[0];
            String value = keyValue[1];
            logger.info("Key: " + key);
            logger.info("Value: " + value);

//            if(key.toUpperCase().equals(ApplicationParams.FILE_NAME.toString())){
//                fileName = value;
//            }

            if(key.toUpperCase().equals(ApplicationParams.TRANSACTIONS.toString())){
                String[] lines = value.split("\n");
                for(String line: lines){
                   try{
                       Message message = messageService.getFromString(line);
                       Transaction transaction = transactionService.getTransaction(message);
                       Boolean isTransactionValid = cardAuthService.authorizeCard(transaction);
                       cardAuthService.getPrintTransactionIsValid(isTransactionValid, line, transaction.responseCode);
                   }catch (Exception ex){
                       // TODO: catch validation exception
                       cardAuthService.printTransactionMissingRequiredField(line);
                   }
                }
            }
        }


//        List<Message> transactionAttempts;
//
//        for (Message transactionAttempt : transactionAttempts) {
//            try {
//                Boolean isTransactionRequestValid = cardAuthService.authorizeCard(new Message());
//                if (isTransactionRequestValid) {
//                    logger.info(transactionAttempt + "OK");
//                } else {
//                    logger.info(transactionAttempt + "DE");
//                }
//            } catch (MethodArgumentNotValidException validationError) {
//                logger.info("${transactionAttempt}ER");
//            } catch (Exception gex) {
//                logger.error("Something went wrong while processing the transaction attempt $tran");
//            }
//        }
    }
}

