package com.vok.vokbook.authentication.controller;

import com.vok.vokbook.authentication.service.AuthenticationService;
import com.vok.vokbook.authentication.controller.dto.AuthenticationResponse;
import com.vok.vokbook.authentication.controller.dto.PasswordAuthenticationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("authenticate")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody PasswordAuthenticationRequest request) {
        AuthenticationResponse response = authenticationService.authenticateUser(request);
        return ResponseEntity.ok(response);
    }
}
