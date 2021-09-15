package com.nru.mytb.domain.places;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlacesRepository extends JpaRepository<Places, Long> {

    List<Places> findAllByOrderByIdDesc();

    List<Places> findTop4ByOrderByCountDesc();

    void deleteAllByUserId(Long userId);
}
