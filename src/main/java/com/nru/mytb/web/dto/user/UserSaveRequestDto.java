package com.nru.mytb.web.dto.user;

import com.nru.mytb.domain.user.Role;
import com.nru.mytb.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class UserSaveRequestDto {

    private String email;
    private String nick;
    private String password;

    @Builder
    public UserSaveRequestDto(String email, String nick, String password) {
        this.email = email;
        this.nick = nick;
        this.password = password;
    }

    public User toEntity() {
        return User.builder()
                .email(email)
                .nick(nick)
                .password(password)
                .role(Role.ROLE_USER)
                .build();
    }
}
