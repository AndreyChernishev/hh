package ru.turnikman.hh.model;

import org.springframework.security.core.GrantedAuthority;

public enum UserAuthority implements GrantedAuthority {
    ADMIN,
    RABOTODATEL,
    SOISKATEL;

    @Override
    public String getAuthority() {
        return this.name();
    }
}
