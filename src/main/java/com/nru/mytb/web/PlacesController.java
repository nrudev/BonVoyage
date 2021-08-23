package com.nru.mytb.web;

import com.nru.mytb.service.places.PlacesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class PlacesController {

    private final PlacesService placesService;

    @GetMapping("/places")
    public String placeList(Model model) {
        model.addAttribute("places", placesService.getList());
        return "/places/place-list";
    }

    @GetMapping("/places/save")
    public String placeSavePage() {
        return "/places/place-save";
    }

    @GetMapping("/places/{id}")
    public String placeDetail(@PathVariable Long id, Model model) {
        model.addAttribute("place", placesService.findById(id));
        return "/places/place-detail";
    }
}
