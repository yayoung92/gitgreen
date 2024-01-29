package org.example.util;

import lombok.Data;
import org.example.member.Member;
@Data
public class Login {
    // DBmember 내용을 저장
    public static Member member;

    // 로그인 여부를 저장
    public static boolean login = false;

    public static String getRole(){
        return member.getRole();
    }
}
