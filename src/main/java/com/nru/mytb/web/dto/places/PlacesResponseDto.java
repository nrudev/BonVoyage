package com.nru.mytb.web.dto.places;

import com.nru.mytb.domain.places.Places;
import com.nru.mytb.domain.user.User;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PlacesResponseDto {

    private Long id;
    private String title;
    private String content;
    private Long count;
    private User user;
    private LocalDateTime createdDate;

    public PlacesResponseDto(Places entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.count = entity.getCount();
        this.user = entity.getUser();
        this.createdDate = entity.getCreatedDate();
    }

}
