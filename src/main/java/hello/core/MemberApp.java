package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {

//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();

        
        //스프링 컨테이너를 의미한다.
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        //스프링 컨테이너에서 memberService 를 꺼내온다.
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);


        //회원가입 예제 -- 순수한 자바코드로 작성
        Member memberA = new Member(1L, "memberA", Grade.VIP);
        memberService.join(memberA);

        Member findmember = memberService.findMember(1L);
        System.out.println("new Member : "+memberA.getName());
        System.out.println("find Member : "+findmember.getName());
    }

}
