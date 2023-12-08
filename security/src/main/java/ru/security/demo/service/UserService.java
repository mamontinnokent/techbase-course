package ru.security.demo.service;

import java.security.Principal;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.val;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.security.demo.domain.user.entity.User;
import ru.security.demo.domain.user.model.ChangePasswordRequest;
import ru.security.demo.repository.UserRepository;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class UserService {

    UserRepository repository;
    PasswordEncoder passwordEncoder;

    public void changePassword(ChangePasswordRequest request, Principal connectedUser) {
        val user = (User) ((UsernamePasswordAuthenticationToken) connectedUser).getPrincipal();

        if (!request.newPassword().equals(request.currentPassword())) {
            throw new IllegalStateException("Password are not the same");
        }

        user.password(passwordEncoder.encode(request.newPassword()));
        repository.save(user);
    }
}
