package com.vok.vokbook.authentication.service;

import com.vok.vokbook.authentication.controller.dto.AuthenticationResponse;
import com.vok.vokbook.authentication.controller.dto.PasswordAuthenticationRequest;

public interface AuthenticationService {
    AuthenticationResponse authenticateUser(PasswordAuthenticationRequest request);
}
