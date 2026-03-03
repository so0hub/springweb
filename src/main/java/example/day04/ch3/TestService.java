package example.day04.ch3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // 서비스(비즈니스) 계층
public class TestService {

    @Autowired MemberRepository memberRepository;

    public List<Member> getAllMembers(){
        return memberRepository.findAll(); // select
    }
    // * 주의 : Member 테이블의 @Setter 추가후 테스트 *

    public boolean saveMember(){
        Member member = new Member(  );
        // member.setName( "유재석" );
        memberRepository.save( member ); // insert
        return true;
    }
} // class end