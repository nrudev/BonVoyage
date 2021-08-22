package com.nru.mytb.service.user;

import com.nru.mytb.domain.user.UserRepository;
import com.nru.mytb.web.dto.user.UserSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional
    @Override
    public Long save(UserSaveRequestDto requestDto) {
        String rawPassword = requestDto.getPassword();
        String encPassword = bCryptPasswordEncoder.encode(rawPassword);
        requestDto.setPassword(encPassword);

        return userRepository.save(requestDto.toEntity()).getId();
    }

    @Override
    public boolean emailValidateCheck(String email) {
        return !(userRepository.findByEmail(email).isPresent());
    }

    @Override
    public boolean nickValidateCheck(String nick) {
        return userRepository.findByNick(nick) == null;
    }
}
