package com.geunskoo.security.domain.user;

import com.geunskoo.security.dto.SignupDto;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;

@Getter
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "nick_name")
    private String nickName;

    @Column(name = "password")          //Credential
    private String password;

    @Column(name = "email")             //Principal
    private String email;

    @Enumerated(EnumType.STRING)
    private Role role;                  //Role (사용자 권한)

    //== 생성 메서드 ==//
    public static User registerUser(SignupDto signupDto) {
        User user = new User();
        user.email = signupDto.getEmail();
        user.password = signupDto.getPassword();
        user.role = Role.USER;

        return user;
    }
}
