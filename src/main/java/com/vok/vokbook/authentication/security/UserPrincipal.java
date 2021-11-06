package com.vok.vokbook.authentication.security;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vok.vokbook.user.domain.User;
import com.vok.vokbook.user.enumerator.LanguageEnum;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class UserPrincipal implements UserDetails {

    private final Long id;
    private final String username;
    @JsonIgnore
    private final String password;
    private final List<SimpleGrantedAuthority> authorities;
    private final String fullName;
    private final LanguageEnum language;


    public UserPrincipal(Long id, String username, String password, List<SimpleGrantedAuthority> authorities, String fullName, LanguageEnum language) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.authorities = authorities;
        this.fullName = fullName;
        this.language = language;
    }

    public static UserPrincipal create(User user) {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        // TODO refacto after roles
        authorities.add(new SimpleGrantedAuthority("ADMIN"));

        /*
        authorities.add(new SimpleGrantedAuthority(user.getRole().get(0).getName().toString()));
        if (user.getRole().size() > 1) {
            authorities.add(new SimpleGrantedAuthority(user.getRole().get(1).getName().toString()));
        }*/
        return new UserPrincipal(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                authorities,
                user.getFirstName() + ' ' + user.getLastName(),
                user.getLanguage()
        );
    }


    public Long getId() {
        return id;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserPrincipal that = (UserPrincipal) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    public String getFullName() {
        return fullName;
    }

    public LanguageEnum getLanguage() {
        return language;
    }

}
