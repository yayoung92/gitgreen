package com.mh.restapi03.users;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

// 속성만들고 유효성 검사하는 클래스
// validation 에 대한 정보를 적을 것이다.
@Data
@ToString
@AllArgsConstructor
public class UserDTO {
    private Long id;
    @NotBlank   // username 빈값 두지 않겠드아.
    private String username;
    private String email;
    private String password;
    private Gender gender;
    @JsonFormat(pattern = "yyy/MM/dd HH:mm:ss")
    private LocalDateTime wdate;

//    public static User of(UserDTO userDTO){
//        User user = new User();
//        user.setId(userDTO.getId());
//        user.setUsername(userDTO.getUsername());
//        user.setEmail(userDTO.getEmail());
//        user.setPassword(userDTO.getPassword());
//        user.setGender(userDTO.getGender());
//        user.setWdate(LocalDateTime.now());
//        return user;
//    }
}