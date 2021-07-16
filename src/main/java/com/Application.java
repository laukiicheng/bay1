package com;

import com.card.models.Message;
import com.services.CardAuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.List;

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


    public static void main(String[] args) {
        logger.info("STARTING THE APPLICATION");
        SpringApplication.run(Application.class, args);
        logger.info("APPLICATION FINISHED");
    }

    @Override
    public void run(String... args) {
        logger.info("EXECUTING : command line runner");

        String fileName = args[0];
//        for (int i = 0; i < args.length; ++i) {
//            logger.info("args[{}]: {}", i, args[i]);
//        }


        List<Message> transactionAttempts;

        for (Message transactionAttempt : transactionAttempts) {
            try {
                Boolean isTransactionRequestValid = cardAuthService.authorizeCard(new Message());
                if (isTransactionRequestValid) {
                    logger.info(transactionAttempt + "OK");
                } else {
                    logger.info(transactionAttempt + "DE");
                }
            } catch (MethodArgumentNotValidException validationError) {
                logger.info("${transactionAttempt}ER");
            } catch (Exception gex) {
                logger.error("Something went wrong while processing the transaction attempt $tran");
            }
        }
    }
}

