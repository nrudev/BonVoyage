package com.nru.mytb.web;

import com.nru.mytb.service.user.UserService;
import com.nru.mytb.web.dto.user.UserSaveRequestDto;
import com.nru.mytb.web.dto.user.UserUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
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

    @PutMapping("/api/user/update/{id}")
    public Long updateUserInfo(@PathVariable Long id, @RequestBody UserUpdateRequestDto requestDto) {
        userService.update(id, requestDto);
        return id;
    }

    @DeleteMapping("/api/user/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
