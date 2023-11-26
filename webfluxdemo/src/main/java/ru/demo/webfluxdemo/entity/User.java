package ru.demo.webfluxdemo.entity;

import java.security.Principal;
import javax.security.auth.Subject;

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
