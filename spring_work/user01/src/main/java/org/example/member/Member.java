package org.example.member;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Member {

    private long id; //pk
    private String emil;
    private String name;
    private String password;
    private String confirmPassword;
    private LocalDate localDate;
}
