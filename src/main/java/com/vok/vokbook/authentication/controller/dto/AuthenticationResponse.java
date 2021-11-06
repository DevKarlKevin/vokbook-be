package com.vok.vokbook.authentication.controller.dto;

import com.vok.vokbook.authentication.security.UserPrincipal;
import com.vok.vokbook.user.enumerator.LanguageEnum;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * Response for sending JWT token and info to front-end.
 *
 * @author Karl Kevin Klais
 */

@Getter
@Setter
public class AuthenticationResponse {
    private Long userId;
    private String accessToken;
    private String fullName;
    private LanguageEnum language;
    private Boolean isFirstSignIn;
    private Collection<? extends GrantedAuthority> authorities;

    public AuthenticationResponse(String accessToken, UserPrincipal principal) {
        this.userId = principal.getId();
        this.accessToken = accessToken;
        this.authorities = principal.getAuthorities();
        this.fullName = principal.getFullName();
        this.language = principal.getLanguage();
    }
}
