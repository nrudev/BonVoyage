package com.nru.mytb.service.user;

import com.nru.mytb.domain.user.User;
import com.nru.mytb.domain.user.UserRepository;
import com.nru.mytb.web.dto.user.UserSaveRequestDto;
import com.nru.mytb.web.dto.user.UserUpdateRequestDto;
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

    @Transactional
    @Override
    public Long update(Long id, UserUpdateRequestDto requestDto) {
        User user = findById(id);

        if (requestDto.getPassword().equals("") || requestDto.getPassword() == null) {
            user.update(user.getPassword(), requestDto.getNick());
        } else {
            String encPassword = bCryptPasswordEncoder.encode(requestDto.getPassword());
            user.update(encPassword, requestDto.getNick());
        }

        return user.getId();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));
    }
}
