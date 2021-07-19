package com.services;

import com.card.models.Message;
import com.card.models.MessageFieldMapping;

import java.util.Map;

public class MessageService {

    private Map<Integer, MessageFieldMapping> bitMapFieldMapping = Map.ofEntries(
            Map.entry(1, MessageFieldMapping.CC_NUMBER),
            Map.entry(2, MessageFieldMapping.EXP_DATE),
            Map.entry(3, MessageFieldMapping.TRANSACTION_IN_CENTS),
            Map.entry(4, MessageFieldMapping.RESPONSE_CODE),
            Map.entry(5, MessageFieldMapping.CARD_HOLDER_NAME),
            Map.entry(6, MessageFieldMapping.ZIP_CODE)
    );

    public Message getFromString(String value) {
        int hexBitMap = Integer.parseInt(value.substring(4, 5), 16);
        String bitMapAsBinaryString = Integer.toBinaryString(hexBitMap);
        String[] bitMap = bitMapAsBinaryString.split("");

        Message message = new Message();
        message.messageType = value.substring(1, 3);
        String messageWithoutMetaData = value.substring(5);

        for (int i = 1; i <= bitMap.length - 1; i++) {
            if (bitMap[i].equals("1")) {
                MessageFieldMapping field = bitMapFieldMapping.get(i);

                int nextIndex = 0;
                if (field == MessageFieldMapping.CC_NUMBER) {
                    // 14-19 characters
                    message.creditCardNumber = messageWithoutMetaData.substring(6, 10);
                    nextIndex += 10;
                }

                if (field == MessageFieldMapping.EXP_DATE) {
                    // 4 characters
                    message.expirationDate = messageWithoutMetaData.substring(nextIndex, nextIndex + 3);
                    nextIndex += 3;
                }

                if (field == MessageFieldMapping.TRANSACTION_IN_CENTS) {
                    // 10 characters
                    message.transactionAmountInCents = messageWithoutMetaData.substring(nextIndex, nextIndex + 9);
                    nextIndex += 9;
                }


                if (field == MessageFieldMapping.RESPONSE_CODE) {
                    // 2 characters
                    message.responseCode = messageWithoutMetaData.substring(nextIndex, nextIndex + 1);
                    nextIndex += 1;
                }

                if (field == MessageFieldMapping.CARD_HOLDER_NAME) {
                    // n characters
                    // not used yet
                }

                if (field == MessageFieldMapping.ZIP_CODE) {
                    // 4 characters
                    message.zipCode = messageWithoutMetaData.substring(messageWithoutMetaData.length() - 3, messageWithoutMetaData.length() - 1);
                }
            }
        }

        return message;
    }
}
