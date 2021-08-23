package com.nru.mytb.web;

import com.nru.mytb.config.auth.PrincipalDetails;
import com.nru.mytb.service.places.PlacesService;
import com.nru.mytb.web.dto.places.PlacesSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class PlacesApiController {

    private final PlacesService placesService;

    @PostMapping("/api/places")
    public Long savePlace(@RequestBody PlacesSaveRequestDto requestDto, @AuthenticationPrincipal PrincipalDetails principal) {

        return placesService.save(requestDto, principal.getUser());
    }

}
