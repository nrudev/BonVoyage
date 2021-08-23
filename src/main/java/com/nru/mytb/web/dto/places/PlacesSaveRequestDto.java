package com.nru.mytb.web.dto.places;

import com.nru.mytb.domain.places.Places;
import com.nru.mytb.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PlacesSaveRequestDto {

    private String title;
    private String content;
    private User user;

    @Builder
    public PlacesSaveRequestDto(String title, String content, User user) {
        this.title = title;
        this.content = content;
        this.user = user;
    }

    public Places toEntity() {
        return Places.builder()
                .title(title)
                .content(content)
                .user(user)
                .build();
    }
}
