package com.urlshortener.urlshortener.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/hello")
public class HelloController {

  // curl --location --request GET 'http://localhost:8080/hello/'
  @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<String> helloCheck(HttpServletRequest request) {
    return ResponseEntity.status(HttpStatus.OK).body("Hello, World!");
  }

}
