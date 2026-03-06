package example.종합.예제10.board.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass // 해당 클래스는 상속을 부여할 때(받을 때 x) 엔티티 매핑에 포함시키겠다.
@Getter // 롬복 : 상속받은 클래스가 멤버변수 접근하도록 허용
@EntityListeners(AuditingEntityListener.class ) // 해당 클래스가 JPA 감지 설정
public class BaseTime {

    @CreatedDate // 생성날짜/시간 주입
    private LocalDateTime createDate; // 생성날짜/시간

    @LastModifiedDate // 수정날짜/시간 주입
    private LocalDateTime updateDate; // 수정날짜/시간
}
