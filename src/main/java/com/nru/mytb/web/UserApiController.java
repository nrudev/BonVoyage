package com.nru.mytb.web;

import com.nru.mytb.service.user.UserService;
import com.nru.mytb.web.dto.user.UserSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class UserApiController {

    private final UserService userService;

    @PostMapping("/api/user")
    public Long saveUser(@RequestBody UserSaveRequestDto requestDto) {
        return userService.save(requestDto);
    }

    @PostMapping("/api/user/emailCheck")
    public boolean emailCheck(@RequestBody String email) {
        return userService.emailValidateCheck(email);
    }

    @PostMapping("/api/user/nickCheck")
    public boolean nickCheck(@RequestBody String nick) {
        return userService.nickValidateCheck(nick);
    }
}
