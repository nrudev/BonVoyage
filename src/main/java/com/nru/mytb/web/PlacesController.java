package com.nru.mytb.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PlacesController {

    @GetMapping("/places")
    public String placeList() {
        return "/places/placeList";
    }

    @GetMapping("/places/save")
    public String placeSavePage() {
        return "/places/place-save";
    }
}
