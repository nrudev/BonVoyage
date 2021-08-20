package com.nru.mytb.domain.user;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @AfterEach
    void tearDown() {
        userRepository.deleteAll();
    }

    @Test
    void userSaveTest() {
        // given
        String email = "asdf@asaf.com";
        String nick = "아아";
        String password = "1234";

        User user = User.builder()
                .email(email)
                .nick(nick)
                .password(password)
                .role(Role.ROLE_USER)
                .build();

        // when
        userRepository.save(user);

        List<User> all = userRepository.findAll();

        // then
        User savedUser = all.get(0);

        assertThat(savedUser.getEmail()).isEqualTo(email);
        assertThat(savedUser.getNick()).isEqualTo(nick);
    }
}