package com.mh.restapi03.users;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@ToString
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")  // 없으면 자동으로 User 테이블이 생성되는데 테이블 이름 users 로 할거야
@Entity  // 이 클래스가 테이블이다!!
@Schema(description = "User Table 에 대한 내용입니다.")
public class User {

    // SEQUENCE -> 테이블을 생성해서 기본키 관리  GenerationType.SEQUENCE
    // IDENTITY -> auto-increment 로 자동증가 GenerationType.IDENTITY
    @Id         // id 로 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // 자동증가 컬럼이야
    @Schema(title = "사용자 ID",description = "table 에서 자동으로 생성되는 컬럼")
    private Long id;

    @Column(length = 50)  // Column 으로 문자열 길이 바꿀 수 있다.
    @Schema(title = "사용자 username",description = "사용자 이름을 넣어주시면 됩니다.")
    private String username;

    @Column(length = 100, unique = true) // unique = true 이메일 중복나면 실패한다는 제약조건
    private String email;

    @JsonIgnore
    private String password;

    //@Enumerated(EnumType.ORDINAL)  // enum 순서대로 0,1,2.. 이렇게 숫자로 넣는거
    @Enumerated(EnumType.STRING)  // enum 문자 그래도 넣고 싶을때
    private Gender gender;

    @JsonFormat(pattern = "yyy/MM/dd HH:mm:ss") // 날짜, 시간 원하는 방식으로 포맷하기
    private LocalDateTime wdate;
}
