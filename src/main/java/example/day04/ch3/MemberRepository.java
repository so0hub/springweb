package example.day04.ch3;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // 리포지토리 (퍼시스턴스) 계층 ,
public interface MemberRepository extends JpaRepository< Member , Long > {
    // 1. 인터페이스 위에 @Repository 붙인다.
    // 2. JpaRepository 로부터 상속받는다.
    // 3. JpaRepository< 매핑클래스명 , pk타입 > 지정한다.
    // * < > 제네릭타입
}