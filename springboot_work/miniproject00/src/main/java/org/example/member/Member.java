package org.example.member;

import lombok.*;

// 어노테이션
@Getter
@Setter
@AllArgsConstructor
@Builder  // Builder 를 써서 많이 한다고 함.
@ToString
public class Member {
    private String email;
    private String name;
    private String address;
    private String password;
    private String role;
}
