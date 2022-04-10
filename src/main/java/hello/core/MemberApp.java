package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

public class MemberApp {

    public static void main(String[] args) {
        //회원가입 예제 -- 순수한 자바코드로 작성
        MemberService memberService = new MemberServiceImpl();
        Member memberA = new Member(1L, "memberA", Grade.VIP);
        memberService.join(memberA);

        Member findmember = memberService.findMember(1L);
        System.out.println("new Member : "+memberA.getName());
        System.out.println("find Member : "+findmember.getName());
    }

}