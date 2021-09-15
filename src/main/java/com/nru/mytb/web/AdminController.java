package com.nru.mytb.web;

import com.nru.mytb.domain.user.User;
import com.nru.mytb.service.user.UserService;
import com.nru.mytb.web.dto.user.UserUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
public class AdminController {

    private final UserService userService;

    @GetMapping("/admin/userList")
    public String userList(Model model, @PageableDefault(size = 5, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<User> userList = userService.getUserList(pageable);

        int pageNum = userList.getPageable().getPageNumber();
        int totalPages = userList.getTotalPages();
        int pageBlock = 5;
        int startBlockPage = (pageNum / pageBlock) * pageBlock + 1;
        int endBlockPage = startBlockPage + pageBlock - 1;
        endBlockPage = totalPages < endBlockPage ? totalPages : endBlockPage;

        model.addAttribute("startBlockPage", startBlockPage);
        model.addAttribute("endBlockPage", endBlockPage);
        model.addAttribute("users", userList);

        return "/user/userList";
    }

    @PutMapping("/api/admin/{id}")
    public @ResponseBody Long changeRole(@PathVariable Long id, @RequestBody UserUpdateRequestDto requestDto) {
        return userService.changeRole(id, requestDto);
    }

    @DeleteMapping("/api/admin/user/{id}")
    public @ResponseBody void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }


}
