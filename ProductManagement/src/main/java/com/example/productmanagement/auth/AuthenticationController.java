package com.example.productmanagement.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

  private final AuthenticationService service;


  @PostMapping("/register")
  public ResponseEntity<?> register(@RequestBody UserRequest request) {

      return new ResponseEntity<>(service.register(request),HttpStatus.OK);
  }

  @PostMapping("/login")
  public AuthenticationResponse authenticate(@RequestBody UserRequest request) {
    return service.authenticate(request); }

  }



