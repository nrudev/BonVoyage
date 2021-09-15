package com.nru.mytb.web.dto.user;

import com.nru.mytb.domain.user.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class UserUpdateRequestDto {

    private String password;
    private String nick;
    private Role role;

    @Builder
    public UserUpdateRequestDto(String password, String nick) {
        this.password = password;
        this.nick = nick;
    }

    public UserUpdateRequestDto(Role role) {
        this.role = role;
    }
}
