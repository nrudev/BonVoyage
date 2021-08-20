package com.nru.mytb.service.user;

import com.nru.mytb.domain.user.UserRepository;
import com.nru.mytb.web.dto.user.UserSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public Long save(UserSaveRequestDto requestDto) {
        return userRepository.save(requestDto.toEntity()).getId();
    }

    @Override
    public boolean emailValidateCheck(String email) {
        return userRepository.findByEmail(email) == null;
    }

    @Override
    public boolean nickValidateCheck(String nick) {
        return userRepository.findByNick(nick) == null;
    }
}
