package ru.security.demo.demo.domain.user.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Accessors(chain = true, fluent = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ChangePasswordRequest {
    String currentPassword;
    String newPassword;
    String confirmationPassword;
}
