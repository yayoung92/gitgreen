package com.mh.restapi03.users;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
public class UserController {
    /*
    get 사용자 조회
    post 사용자 등록
    put 사용자 수정
    delete 사용자 삭제
     */
    private final UserService userService;

    @PostMapping("users")
    public User addUser(@RequestBody User reqUser){
        User user = User.builder()
                .username(reqUser.getUsername())
                .password(reqUser.getPassword())  // 1234 이렇게 넣으면 안되고 인코딩(암호화)해서 저장해야한다.
                .email(reqUser.getEmail())
                .wdate(LocalDateTime.now())
                .gender(reqUser.getGender())
                .build();
        User dbUser = userService.regist(user);
        return dbUser;
    }
}
