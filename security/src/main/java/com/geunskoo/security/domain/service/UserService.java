package com.geunskoo.security.domain.service;

import com.geunskoo.security.domain.dao.UserRepository;
import com.geunskoo.security.domain.user.User;
import com.geunskoo.security.dto.SignupDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public void registerUser(SignupDto signupDto) {
        User user = User.registerUser(signupDto);
        userRepository.save(user);
    }
}
