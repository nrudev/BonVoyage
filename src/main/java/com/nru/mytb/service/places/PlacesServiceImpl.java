package com.nru.mytb.service.places;

import com.nru.mytb.domain.places.PlacesRepository;
import com.nru.mytb.domain.user.User;
import com.nru.mytb.web.dto.places.PlacesSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PlacesServiceImpl implements PlacesService {

    private final PlacesRepository placesRepository;

    @Override
    public Long save(PlacesSaveRequestDto requestDto, User user) {
        requestDto.setUser(user);
        return placesRepository.save(requestDto.toEntity()).getId();
    }
}
