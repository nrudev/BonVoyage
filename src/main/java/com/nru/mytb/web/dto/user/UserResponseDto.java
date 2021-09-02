package com.nru.mytb.web.dto.user;

import com.nru.mytb.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class UserResponseDto {

    private Long id;
    private String email;
    private String password;
    private String nick;

    public UserResponseDto(User entity) {
        this.id = entity.getId();
        this.email = entity.getEmail();
        this.password = entity.getPassword();
        this.nick = entity.getNick();
    }
}
