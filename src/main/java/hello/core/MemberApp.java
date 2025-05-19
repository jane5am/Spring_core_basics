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

        // ApplicationContext 얘가 스프링 컨테이너라고 생각하면 된다
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        // 기존에 AppConfig에서 직접 찾아오던걸 스프링컨테이너에서 가져온다
        // 스프링컨테이너에는 @Bean붙은 메소드의 이름으로 등록되어있어서 "memberService"라는 이름으로 꺼내는 것
        // MemberService.class 이건 타
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find member = " + findMember.getName());

    }
}
