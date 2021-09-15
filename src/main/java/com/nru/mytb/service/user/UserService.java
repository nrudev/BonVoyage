package com.nru.mytb.service.user;

import com.nru.mytb.domain.user.User;
import com.nru.mytb.web.dto.user.UserSaveRequestDto;
import com.nru.mytb.web.dto.user.UserUpdateRequestDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    Long save(UserSaveRequestDto requestDto);

    boolean emailValidateCheck(String email);

    boolean nickValidateCheck(String nick);

    Long update(Long id, UserUpdateRequestDto requestDto);

    User findById(Long id);

    Page<User> getUserList(Pageable pageable);

    Long changeRole(Long id, UserUpdateRequestDto requestDto);

    void deleteUser(Long id);
}
