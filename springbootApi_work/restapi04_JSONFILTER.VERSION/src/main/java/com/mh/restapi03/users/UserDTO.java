package com.mh.restapi03.users;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

// 속성만들고 유효성 검사하는 클래스
// validation 에 대한 정보를 적을 것이다.
@Data
@ToString
@AllArgsConstructor
@Schema(description = "UserDTO 에 대한 내용입니다.")
public class UserDTO {
    private Long id;
    @NotBlank   // username 빈값 두지 않겠드아.
    //@Pattern(regexp = "^[a-zA-Z0-9]*$", message = "사용자이름은 영어랑 숫자만 가능합니다.")
    private String username;

    @Size(min=5, max=50)
    private String email;
    private String password;
    //@Min(10)  // 최소 10자리 이상 되어야 한다는 유효성 검사

    //@Min(5)

    //@NotNull
    private Gender gender;
    @JsonFormat(pattern = "yyy/MM/dd HH:mm:ss")
    private LocalDateTime wdate;


}
