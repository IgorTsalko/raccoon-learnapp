package com.raccoon.learnapp.auth.service;

import com.raccoon.learnapp.auth.model.AppUserDetails;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class AppUserDetailsService implements UserDetailsService {

    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // todo: delete mock user
        // todo: load user with the user-service
        return new AppUserDetails(
                1L,
                "tracer.pk@mail.ru",
                passwordEncoder.encode("tracer123"),
                List.of("SUPER_USER"),
                true
        );
    }
}
