package ru.security.demo.domain.auth.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;
import ru.security.demo.domain.user.entity.Role;

@Data
@Accessors(chain = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RegisterRequest {

    String email;
    String password;
    Role role;
}
