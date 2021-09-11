package com.nru.mytb.web;

import com.nru.mytb.service.places.PlacesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PlacesService placesService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("tops", placesService.findTop4ByOrderByCountDesc());
        return "index";
    }

    @GetMapping("/loginForm")
    public String login() {
        return "loginForm";
    }

    @GetMapping("/signup")
    public String signup() {
        return "signupForm";
    }

    @GetMapping("/user/{id}")
    public String userInfo(@PathVariable Long id) {
        return "userInfo";
    }

}
