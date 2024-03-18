package com.ygy.restapi05.member;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본키(pk) 생성
    private Long id;
    @Column(length = 50, nullable = false)  // 길이 변경하기. 기본값은 255 이다. nullable = false -> null 허용하지 않는 제약조건
    private String username;
    private String password;
    @Column(length = 50, nullable = false, unique = true) // 길이 50으로 변경, null 허용하지 않고, 중복값 갖지 않게 unique
    private String email;
    @Enumerated(EnumType.STRING)  // USER, ADMIN 만 가지게 된다.
    private Role role;
    @CreatedDate  // insert 한 시간
    private LocalDateTime wirteDate; // 작성한 날짜
    @LastModifiedDate // 마지막에 수정하거나 삭제한 시간
    private LocalDateTime modifyDate; // 수정한 날짜
}
