package com.nru.mytb.service.places;

import com.nru.mytb.domain.places.Places;
import com.nru.mytb.domain.user.User;
import com.nru.mytb.web.dto.places.PlacesResponseDto;
import com.nru.mytb.web.dto.places.PlacesSaveRequestDto;
import com.nru.mytb.web.dto.places.PlacesUpdateRequestDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PlacesService {

    Long save(PlacesSaveRequestDto requestDto, User user);

    Page<Places> getList(Pageable pageable);

    PlacesResponseDto findById(Long id);

    Long update(Long id, PlacesUpdateRequestDto requestDto);

    void remove(Long id);

    List<PlacesResponseDto> findTop4ByOrderByCountDesc();
}
