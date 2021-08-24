package com.nru.mytb.web;

import com.nru.mytb.domain.places.Places;
import com.nru.mytb.service.places.PlacesService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class PlacesController {

    private final PlacesService placesService;

    @GetMapping("/places")
    public String placeList(Model model, @PageableDefault(size = 5, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<Places> places = placesService.getList(pageable);

        int pageNum = places.getPageable().getPageNumber(); // 현재 페이지
        int totalPages = places.getTotalPages();// 총 페이지수
        int pageBlock = 5; // 블럭의 수
        int startBlockPage = (pageNum / pageBlock) * pageBlock + 1;
        int endBlockPage = startBlockPage + pageBlock - 1;
        endBlockPage = totalPages < endBlockPage ? totalPages : endBlockPage;

        model.addAttribute("startBlockPage", startBlockPage);
        model.addAttribute("endBlockPage", endBlockPage);
        model.addAttribute("places", places);
        
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

    @GetMapping("/places/update/{id}")
    public String placeUpdate(@PathVariable Long id, Model model) {
        model.addAttribute("place", placesService.findById(id));
        return "/places/place-update";
    }
}
