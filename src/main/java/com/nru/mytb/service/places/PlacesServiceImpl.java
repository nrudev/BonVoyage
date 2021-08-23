package com.nru.mytb.service.places;

import com.nru.mytb.domain.places.Places;
import com.nru.mytb.domain.places.PlacesRepository;
import com.nru.mytb.domain.user.User;
import com.nru.mytb.web.dto.places.PlacesResponseDto;
import com.nru.mytb.web.dto.places.PlacesSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PlacesServiceImpl implements PlacesService {

    private final PlacesRepository placesRepository;

    @Override
    public Long save(PlacesSaveRequestDto requestDto, User user) {
        requestDto.setUser(user);
        return placesRepository.save(requestDto.toEntity()).getId();
    }

    @Override
    public List<PlacesResponseDto> getList() {
        return placesRepository.findAllByOrderByIdDesc().stream()
                .map(PlacesResponseDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public PlacesResponseDto findById(Long id) {
        Places entity = placesRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시물이 없습니다."));

        return new PlacesResponseDto(entity);
    }
}
