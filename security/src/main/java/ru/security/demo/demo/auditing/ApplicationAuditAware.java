package ru.security.demo.demo.auditing;

import org.springframework.data.domain.AuditorAware;
import org.springframework.lang.NonNullApi;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import ru.security.demo.demo.domain.user.entity.User;

import java.util.Optional;

//public class ApplicationAuditAware implements AuditorAware<Integer> {
//    @Override
//    public Optional<Integer> getCurrentAuditor() {
//        Authentication authentication =
//                SecurityContextHolder
//                        .getContext()
//                        .getAuthentication();
//        if (authentication == null ||
//            !authentication.isAuthenticated() ||
//                authentication instanceof AnonymousAuthenticationToken
//        ) {
//            return Optional.empty();
//        }
//
//        User userPrincipal = (User) authentication.getPrincipal();
//        return Optional.ofNullable(userPrincipal.id());
//    }
//}