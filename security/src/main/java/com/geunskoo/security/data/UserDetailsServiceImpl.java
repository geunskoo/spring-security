package com.geunskoo.security.data;

import com.geunskoo.security.domain.dao.UserRepository;
import com.geunskoo.security.domain.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User findUser = userRepository.findByEmail(email)
            .orElseThrow(() -> new UsernameNotFoundException("Can't not find user with this email. -> " + email));

        if (findUser != null) {
            UserDetailsImpl userDetails = new UserDetailsImpl(findUser);
            return userDetails;
        }
        return null;
    }
}
