package com.nru.mytb.web;

import com.nru.mytb.config.auth.PrincipalDetails;
import com.nru.mytb.service.places.PlacesService;
import com.nru.mytb.web.dto.places.PlacesSaveRequestDto;
import com.nru.mytb.web.dto.places.PlacesUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PlacesApiController {

    private final PlacesService placesService;

    @PostMapping("/api/places")
    public Long savePlace(@RequestBody PlacesSaveRequestDto requestDto, @AuthenticationPrincipal PrincipalDetails principal) {

        return placesService.save(requestDto, principal.getUser());
    }

    @PutMapping("/api/places/{id}")
    public Long updatePlace(@PathVariable Long id, @RequestBody PlacesUpdateRequestDto requestDto) {
        return placesService.update(id, requestDto);
    }

    @DeleteMapping("/api/places/{id}")
    public void removePlace(@PathVariable Long id) {
        placesService.remove(id);
    }

}
