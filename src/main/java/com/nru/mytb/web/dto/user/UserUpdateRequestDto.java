package com.nru.mytb.web.dto.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class UserUpdateRequestDto {

    private String password;
    private String nick;

    @Builder
    public UserUpdateRequestDto(String password, String nick) {
        this.password = password;
        this.nick = nick;
    }
}
