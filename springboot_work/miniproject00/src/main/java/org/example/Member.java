package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

// 어노테이션
@Getter
@Setter
@AllArgsConstructor
public class Member {
    private String email;
    private String name;
    private String address;
    private String password;


}
