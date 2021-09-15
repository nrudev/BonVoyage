package com.nru.mytb.domain.user;

import com.nru.mytb.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String nick;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    private String provider;
    private String providerId;

    @Builder
    public User(String email, String nick, String password, Role role, String provider, String providerId) {
        this.email = email;
        this.nick = nick;
        this.password = password;
        this.role = role;
        this.provider = provider;
        this.providerId = providerId;
    }

    public void update(String password, String nick) {
        this.password = password;
        this.nick = nick;
    }

    public void update(Role role) {
        this.role = role;
    }
}
