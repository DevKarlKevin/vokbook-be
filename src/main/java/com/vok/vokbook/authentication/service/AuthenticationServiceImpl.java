package com.vok.vokbook.authentication.service;

import com.vok.vokbook.authentication.controller.dto.AuthenticationResponse;
import com.vok.vokbook.authentication.controller.dto.PasswordAuthenticationRequest;
import com.vok.vokbook.authentication.security.JwtTokenProvider;
import com.vok.vokbook.authentication.security.UserPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider tokenProvider;

    @Override
    public AuthenticationResponse authenticateUser(PasswordAuthenticationRequest request) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = tokenProvider.generateToken(authentication);
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        return new AuthenticationResponse(jwt, userPrincipal);
    }
}
