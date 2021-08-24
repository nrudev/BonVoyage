package com.nru.mytb.service.places;

import com.nru.mytb.domain.user.User;
import com.nru.mytb.web.dto.places.PlacesResponseDto;
import com.nru.mytb.web.dto.places.PlacesSaveRequestDto;
import com.nru.mytb.web.dto.places.PlacesUpdateRequestDto;

import java.util.List;

public interface PlacesService {

    Long save(PlacesSaveRequestDto requestDto, User user);

    List<PlacesResponseDto> getList();

    PlacesResponseDto findById(Long id);

    Long update(Long id, PlacesUpdateRequestDto requestDto);
}
