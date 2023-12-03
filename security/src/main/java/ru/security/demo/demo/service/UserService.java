package ru.security.demo.demo.service;

import java.security.Principal;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.val;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.security.demo.demo.domain.user.entity.User;
import ru.security.demo.demo.domain.user.model.ChangePasswordRequest;
import ru.security.demo.demo.repository.UserRepository;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class UserService {

    UserRepository repository;
    PasswordEncoder passwordEncoder;

    public void changePassword(ChangePasswordRequest request, Principal connectedUser) {
        val user = (User) ((UsernamePasswordAuthenticationToken) connectedUser).getPrincipal();

        // check if the current password is correct
        if (!passwordEncoder.matches(request.currentPassword(), user.getPassword())) {
            throw new IllegalStateException("Wrong password");
        }
        // check if the two new passwords are the same
        if (!request.newPassword().equals(request.confirmationPassword())) {
            throw new IllegalStateException("Password are not the same");
        }

        // update the password
        user.password(passwordEncoder.encode(request.newPassword()));

        // save the new password
        repository.save(user);
    }
}
