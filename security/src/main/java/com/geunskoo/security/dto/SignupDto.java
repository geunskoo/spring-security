package com.geunskoo.security.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SignupDto {

    private String email;
    private String password;

    @Builder
    public SignupDto(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public static SignupDto encodePassword(SignupDto signupDto, String encodedPassword) {
        SignupDto newSignupDto = new SignupDto();
        newSignupDto.email = signupDto.getEmail();
        newSignupDto.password = encodedPassword;
        return newSignupDto;
    }
}
