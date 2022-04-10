package hello.core.discount;

import hello.core.member.Member;

//할인정책
public interface DiscountPolicy {

    /*
    return 할인 대상 금액 (할인된 금액을 리턴)
     */
    int count(Member member, int price);

}
