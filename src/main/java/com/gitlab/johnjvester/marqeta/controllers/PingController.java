package com.gitlab.johnjvester.marqeta.controllers;

import com.gitlab.johnjvester.marqeta.models.responses.MarqetaPingResponse;
import com.gitlab.johnjvester.marqeta.services.PingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@Slf4j
@CrossOrigin
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class PingController {
    private final PingService pingService;

    @GetMapping(value = "/ping")
    public ResponseEntity<MarqetaPingResponse> ping() {
        try {
            return new ResponseEntity<>(pingService.ping(), HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
