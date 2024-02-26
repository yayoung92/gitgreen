package org.example.member;

import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Collection;

@NoArgsConstructor
public class MemberService {
    private MemberDAO memberDAO;

    public MemberService(MemberDAO memberDAO) {
        this.memberDAO = memberDAO;
    }

    public void setMemberDAO(MemberDAO memberDAO){
        this.memberDAO = memberDAO;
    }
    public void regist(MemberDTO md) {

        Member member = new Member(
                0,
                md.getEmil(),
                md.getName(),
                md.getPassword(),
                md.getConfirmPassword(),
                LocalDate.now()
        );

        memberDAO.insert(member);
    }

    public void list() {
        Collection<Member> collection = memberDAO.select();
        collection.stream()
                .forEach(System.out::println);
    }
}
