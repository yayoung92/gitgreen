package org.example.member;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Builder
public class Member {
    private Long id;
    private String emil;
    private String name;
    private String password;
    private String wdate;
}
