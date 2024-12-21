package hello.core.member;

public class MemberServiceImpl implements MemberService{

    // MemberServiceImpl은 MemberRepository라는 인터페이스(추상화)도 의존하고,
    // MemoryMemberRepository라는 구현체도 의존하고 있어 좋지 않다.

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
