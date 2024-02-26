package com.git.ex03.member;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MemberRepository {
    Map<String, Member> map = new HashMap<>();

    public void insert(Member member) {
        map.put(member.getEmil(), member);
        System.out.println("memberRepository 확인하는 중입니더~");
    }

    public Collection<Member> select() {
       // Set<String> keys = map.keySet(); // -> key 값 받기
        return map.values();
    }
}