package com.nru.mytb.web.dto.places;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class PlacesUpdateRequestDto {

    private String title;
    private String content;

    @Builder
    public PlacesUpdateRequestDto(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
