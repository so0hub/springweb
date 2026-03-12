package example.day05.mvc;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamRepository extends JpaRepository< ExamEntity , Integer > {
    // extends JpaRepository< 조작할엔티티명 , PK타입 >
}
// Repository 데이터베이스의 특정 엔티티(테이블) 조작( DML ) 인터페이스
