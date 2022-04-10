package hello.core.order;

import hello.core.member.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {
    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder(){
        Long memberId = 1L;
        Member memberA = new Member(memberId, "memberId", Grade.VIP);
        memberService.join(memberA);

        Order itemA = orderService.createOrder(memberId, "itemA", 10000);
        Assertions.assertThat(itemA.getDiscountPrice()).isEqualTo(1000);


    }

}
