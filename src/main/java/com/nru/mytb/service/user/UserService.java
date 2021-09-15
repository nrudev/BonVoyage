package com.nru.mytb.service.user;

import com.nru.mytb.domain.user.User;
import com.nru.mytb.web.dto.user.UserSaveRequestDto;
import com.nru.mytb.web.dto.user.UserUpdateRequestDto;

import java.util.List;

public interface UserService {

    Long save(UserSaveRequestDto requestDto);

    boolean emailValidateCheck(String email);

    boolean nickValidateCheck(String nick);

    Long update(Long id, UserUpdateRequestDto requestDto);

    User findById(Long id);

    List<User> findAllByOrderByIdDesc();

    Long changeRole(Long id, UserUpdateRequestDto requestDto);
}
