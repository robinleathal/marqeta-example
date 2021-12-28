package com.gitlab.johnjvester.marqeta.controllers;

import com.gitlab.johnjvester.marqeta.models.PaymentCard;
import com.gitlab.johnjvester.marqeta.services.FundingSourceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@CrossOrigin
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class PaymentCardController {
    private final FundingSourceService fundingSourceService;

    @GetMapping(value = "/paymentcards/user/{userToken}")
    public ResponseEntity<List<PaymentCard>> getPaymentCardsByUserToken(@PathVariable String userToken) {
        try {
            return new ResponseEntity<>(fundingSourceService.getPaymentCardsByUserToken(userToken), HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/paymentcards/{paymentCardToken}")
    public ResponseEntity<PaymentCard> getPaymentCardByPaymentCardToken(@PathVariable String paymentCardToken) {
        try {
            return new ResponseEntity<>(fundingSourceService.getPaymentCardByPaymentCardToken(paymentCardToken), HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
