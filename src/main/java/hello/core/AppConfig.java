package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//구성정보라는것을 알려주는 애노테이션 -- 스프링은 이를 적어주게 되어있음.
@Configuration
public class AppConfig {

    //각 메소드에 @Bean 을 달아주면 스프링 컨테이너에 등록이 됨
    @Bean
    //MemberService 는 메모리 멤버 리포지토리를 사용할것임
    public MemberService memberService(){
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(MemberRepository());
    }

    @Bean
    public MemberRepository MemberRepository() {
        System.out.println("call AppConfig.MemberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(MemberRepository(), DiscountPolicy());
    }

    @Bean
    public DiscountPolicy DiscountPolicy() {
        return new RateDiscountPolicy();
    }


}
