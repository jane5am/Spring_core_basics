package hello.core;

import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig {

    // AppConfig에서 애플리케이션의 실제 동작에 필요한 구현객체를 생성한다
    // 역할을 한눈에 볼 수 있게 구분해줬다

    // 멤버서비스는 멤버서비스impl을 구현해서 쓴다
    // 그리고 멤버서비스impl은 멤버 레포지토리를 사용한다
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    // 멤버레포지토리는 메모리 멤버 레포지토리를 쓸거야
    private static MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), new RateDiscountPolicy());
    }

}
