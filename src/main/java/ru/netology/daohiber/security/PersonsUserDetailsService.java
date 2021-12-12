package ru.netology.daohiber.security;

import lombok.AllArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.netology.daohiber.entity.security.CustomUser;
import ru.netology.daohiber.repo.UserPermissionsRepo;
import ru.netology.daohiber.repo.UsersSecurityRepo;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class PersonsUserDetailsService implements UserDetailsService {

    private final UsersSecurityRepo usersSecurityRepo;
    private final UserPermissionsRepo userPermissionsRepo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        PasswordEncoder encoder = new BCryptPasswordEncoder();

        CustomUser customUser = usersSecurityRepo.findById(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));

        List<SimpleGrantedAuthority> authorities =
                userPermissionsRepo.getPermissionsByUserName(customUser.getUsername()).stream()
                        .map(x -> new SimpleGrantedAuthority(x.getPermissionName()))
                        .collect(Collectors.toList());

        String password = encoder.encode(customUser.getPassword());

        return new User(
                customUser.getUsername(),
                password,
                authorities
        );
    }
}
