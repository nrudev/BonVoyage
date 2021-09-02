package com.nru.mytb.service.user;

import com.nru.mytb.web.dto.user.UserSaveRequestDto;
import com.nru.mytb.web.dto.user.UserUpdateRequestDto;

public interface UserService {

    Long save(UserSaveRequestDto requestDto);

    boolean emailValidateCheck(String email);

    boolean nickValidateCheck(String nick);

    Long update(Long id, UserUpdateRequestDto requestDto);

}
