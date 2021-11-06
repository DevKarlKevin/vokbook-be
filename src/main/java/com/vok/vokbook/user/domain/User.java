package com.vok.vokbook.user.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vok.vokbook.common.AuditableEntity;
import com.vok.vokbook.user.enumerator.LanguageEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "user_account")
public class User extends AuditableEntity {

    private String username;

    @JsonIgnore
    private String password;

    private String firstName;

    private String lastName;

    @Enumerated(EnumType.STRING)
    private LanguageEnum language;

    // TODO roles
}
