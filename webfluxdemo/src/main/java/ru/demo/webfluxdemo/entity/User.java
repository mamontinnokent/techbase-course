package ru.demo.webfluxdemo.entity;

import javax.security.auth.Subject;
import java.nio.file.attribute.UserPrincipal;
import java.security.Principal;

public class User implements Principal {
    @Override
    public String getName() {
        return null;
    }

    @Override
    public boolean implies(Subject subject) {
        return Principal.super.implies(subject);
    }
}
