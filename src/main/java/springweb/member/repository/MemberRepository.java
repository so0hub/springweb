package springweb.member.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import springweb.member.entity.MemberEntity;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity,Long> {

    // [1] 아이디로 엔티티 찾기
    // findBy필드명( 값 ) : 필드명 카멜 규칙 !!!
    Optional<MemberEntity> findByMid(String mid);
    // vs
    // @Query("select * from member where mid = :mid")
    // MemberEntity query(String mid);
}