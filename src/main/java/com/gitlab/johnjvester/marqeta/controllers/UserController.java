package com.gitlab.johnjvester.marqeta.controllers;

import com.gitlab.johnjvester.marqeta.models.User;
import com.gitlab.johnjvester.marqeta.services.UserService;
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
public class UserController {
    private final UserService userService;

    @GetMapping(value = "/users")
    public ResponseEntity<List<User>> getUsers() {
        try {
            return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/users/{userToken}")
    public ResponseEntity<User> getUsers(@PathVariable String userToken) {
        try {
            return new ResponseEntity<>(userService.getUserByToken(userToken), HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
