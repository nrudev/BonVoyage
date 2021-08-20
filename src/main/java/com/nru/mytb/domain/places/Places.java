package com.nru.mytb.domain.places;

import com.nru.mytb.domain.BaseTimeEntity;
import com.nru.mytb.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Places extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    private Long count;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @Builder
    public Places(String title, String content, Long count, User user) {
        this.title = title;
        this.content = content;
        this.count = count;
        this.user = user;
    }
}
