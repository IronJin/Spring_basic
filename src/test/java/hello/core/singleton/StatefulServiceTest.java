package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void StatefulServiceSinggleton() {

        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        //ThreadA : 고객a가 만원을 주문
        int userA = statefulService1.order("UserA", 10000);
        //ThreadB : 고객 b가 2만원을 주문
        int userB = statefulService2.order("UserB", 20000);

        //ThreadA : 사용자 A가 주문 금액 조회
        //int price = statefulService1.getPrice();
        //결과가 만원이 나와야하는데 2만원이 나와버림
        System.out.println("price = " + userA);

        //Assertions.assertThat(statefulService1.getPrice()).isEqualTo(statefulService2.getPrice());

    }

    static class TestConfig {
        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }

}