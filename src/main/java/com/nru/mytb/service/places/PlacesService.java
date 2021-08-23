package com.nru.mytb.service.places;

import com.nru.mytb.domain.user.User;
import com.nru.mytb.web.dto.places.PlacesSaveRequestDto;

public interface PlacesService {

    Long save(PlacesSaveRequestDto requestDto, User user);
}
