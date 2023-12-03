package ru.security.demo.demo.domain.auth.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;
import ru.security.demo.demo.domain.user.entity.Role;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true, fluent = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RegisterRequest {

    String email;
    String password;
    Role role;
}
