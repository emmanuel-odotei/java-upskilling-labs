package week3_labs.Lab_1.src.main.java.com.example.spring_sec_jwt.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Getter
@RequiredArgsConstructor
public enum Role {
    USER(Collections.EMPTY_SET),
    ADMIN(Set.of(
            Permission.ADMIN_CREATE,
            Permission.ADMIN_DELETE,
            Permission.ADMIN_UPDATE,
            Permission.ADMIN_GET,
            Permission.MANAGER_CREATE,
            Permission.MANAGER_DELETE,
            Permission.MANAGER_UPDATE,
            Permission.MANAGER_GET
    )),
    MANAGER(Set.of(
            Permission.MANAGER_CREATE,
            Permission.MANAGER_DELETE,
            Permission.MANAGER_UPDATE,
            Permission.MANAGER_GET
    ));

    private final Set<Permission> permissions;


    public List<SimpleGrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> listOfPermissions = this.getPermissions().stream()
                .map((permission -> new SimpleGrantedAuthority(permission.name())))
                .collect(Collectors.toList());

        listOfPermissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return listOfPermissions;
    }
}
