package com.vok.vokbook.authentication.controller.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class PasswordAuthenticationRequest {
    @NotBlank
    private String username;

    @NotBlank
    private String password;
}
