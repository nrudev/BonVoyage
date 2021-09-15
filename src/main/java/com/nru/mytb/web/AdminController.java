package com.nru.mytb.web;

import com.nru.mytb.service.user.UserService;
import com.nru.mytb.web.dto.user.UserUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
public class AdminController {

    private final UserService userService;

    @GetMapping("/admin/userList")
    public String userList(Model model) {
        model.addAttribute("users", userService.findAllByOrderByIdDesc());
        return "/user/userList";
    }

    @PutMapping("/api/admin/{id}")
    public @ResponseBody Long changeRole(@PathVariable Long id, @RequestBody UserUpdateRequestDto requestDto) {
        return userService.changeRole(id, requestDto);
    }

}
