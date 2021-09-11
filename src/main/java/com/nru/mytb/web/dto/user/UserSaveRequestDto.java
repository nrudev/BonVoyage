package com.nru.mytb.web.dto.user;

import com.nru.mytb.domain.user.Role;
import com.nru.mytb.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class UserSaveRequestDto {

    private String email;
    private String nick;
    private String password;
    private String provider;
    private String providerId;

    @Builder
    public UserSaveRequestDto(String email, String nick, String password, String provider, String providerId) {
        this.email = email;
        this.nick = nick;
        this.password = password;
        this.provider = provider;
        this.providerId = providerId;
    }

    public User toEntity() {
        return User.builder()
                .email(email)
                .nick(nick)
                .password(password)
                .role(Role.ROLE_USER)
                .provider(provider)
                .providerId(providerId)
                .build();
    }
}
