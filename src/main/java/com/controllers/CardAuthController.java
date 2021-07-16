package com.controllers;

import com.card.models.Message;
import com.services.CardAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller("card")
public class CardAuthController {
    @Autowired
    private CardAuthService cardAuthService;

    @PostMapping("auth")
    public @ResponseBody
    ResponseEntity<String> postCardAuth(@RequestBody @Valid Message request) {
        Boolean isCardValid = cardAuthService.authorizeCard(request);

        // TODO: What do they mean by response code?
        if (isCardValid) {
            return new ResponseEntity<String>(request.responseCode, HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("DE", HttpStatus.OK);
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public String constraintViolation(MethodArgumentNotValidException ex) {
        return "ER";
    }
}
