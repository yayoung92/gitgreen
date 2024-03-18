package com.ygy.restapi05.member;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.stereotype.Service;

@Getter
@Service
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class MemberDTO {

    private Long id;

    @Size(min = 3, max = 50)  // username 길이 3~50 으로 제한걸기
    //@Min(3)
    //@Max(50)
    private String username;

    @NotBlank
    private String password;

    @NotBlank
    private String email;

    private Role role;

}
