package com.nru.mytb.service.places;

import com.nru.mytb.domain.places.Places;
import com.nru.mytb.domain.places.PlacesRepository;
import com.nru.mytb.domain.user.User;
import com.nru.mytb.web.dto.places.PlacesResponseDto;
import com.nru.mytb.web.dto.places.PlacesSaveRequestDto;
import com.nru.mytb.web.dto.places.PlacesUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PlacesServiceImpl implements PlacesService {

    private final PlacesRepository placesRepository;

    @Override
    @Transactional
    public Long save(PlacesSaveRequestDto requestDto, User user) {
        requestDto.setUser(user);
        return placesRepository.save(requestDto.toEntity()).getId();
    }

    @Override
    @Transactional
    public Page<Places> getList(Pageable pageable) {
        return placesRepository.findAll(pageable);
    }

    @Override
    @Transactional
    public PlacesResponseDto findById(Long id) {
        Places entity = placesRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시물이 없습니다."));
        entity.updateCount(entity.getCount() + 1);
        return new PlacesResponseDto(entity);
    }

    @Override
    @Transactional
    public Long update(Long id, PlacesUpdateRequestDto requestDto) {
        Places places = placesRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시물이 없습니다."));
        places.update(requestDto.getTitle(), requestDto.getContent());

        return places.getId();
    }

    @Override
    public void remove(Long id) {
        placesRepository.deleteById(id);
    }

    @Override
    public List<PlacesResponseDto> findTop4ByOrderByCountDesc() {
        return placesRepository.findTop4ByOrderByCountDesc().stream()
                .map(PlacesResponseDto::new)
                .collect(Collectors.toList());
    }
}
