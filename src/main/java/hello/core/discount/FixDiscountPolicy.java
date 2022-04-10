package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

//정액할인 정책
public class FixDiscountPolicy implements DiscountPolicy{

    private int discountFixAmount = 1000;

    //VIP면 1000원 할인해주고 아니면 할인해주지 않음
    @Override
    public int count(Member member, int price) {
        if(member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        } else {
            return 0;
        }
    }
}
