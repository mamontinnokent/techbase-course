package ru.security.demo.domain.user.entity;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public enum Role {
    USER(Set.of(Permission.USER_READ)),
    ADMIN(Set.of(Permission.ADMIN_READ, Permission.ADMIN_UPDATE, Permission.ADMIN_DELETE, Permission.ADMIN_CREATE));

//    String key;
    @Getter Set<Permission> permissions;

//    @JsonValue
//    public String getKey() {
//        return key;
//    }
//
//    public static Role of(String key) {
//        return Arrays.stream(Role.values())
//                .filter(role -> role.key.equals(key))
//                .findFirst()
//                .orElse(USER);
//    }

    public List<SimpleGrantedAuthority> getAuthorities() {
        var authorities = permissions.stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toList());
        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return authorities;
    }
}
