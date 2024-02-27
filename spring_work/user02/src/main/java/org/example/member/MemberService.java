package org.example.member;

import org.example.component.AABBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class MemberService {

    @Autowired
    @Qualifier("AABBService")
    AABBService aabbService;

    @Autowired
    MemberDAO memberDAO;

    // Member map 등록하러 가야함
    public void Regist(Member member){
        memberDAO.insert(member);
    }

    // 내용을 출력한다.
    public void List(){
        Collection<Member> collection = memberDAO.select();
        collection.forEach(System.out::println);
    }
}
