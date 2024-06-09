package ru.marinin.controllers;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class mainController {
    @GetMapping(value = "/")
    public ResponseEntity<?> main() {
        System.out.println("asd");
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
