package com.gitlab.johnjvester.marqeta.controllers;

import com.gitlab.johnjvester.marqeta.models.requests.MarqetaTransactionRequest;
import com.gitlab.johnjvester.marqeta.models.responses.MarqetaTransactionPostResponse;
import com.gitlab.johnjvester.marqeta.services.AuthorizationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@Slf4j
@CrossOrigin
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class AuthorizationController {
    private final AuthorizationService authorizationService;

    @PostMapping(value = "/authorization")
    public ResponseEntity<MarqetaTransactionPostResponse> postTransaction(@RequestBody MarqetaTransactionRequest request) {
        try {
            return new ResponseEntity<>(authorizationService.postTransaction(request), HttpStatus.CREATED);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
