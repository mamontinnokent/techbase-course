package ru.security.demo.demo.domain.user.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.security.demo.demo.domain.token.entity.Token;

import java.util.Collection;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Accessors(chain = true, fluent = true)
@Table(name = "user")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User implements UserDetails {

  @Id
  @GeneratedValue
  Integer id;
  String firstname;
  String lastname;
  String email;
  String password;

  @Enumerated(EnumType.STRING)
  Role role;

  @OneToMany(mappedBy = "user")
  List<Token> tokens;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return role.getAuthorities();
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return email;
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
}