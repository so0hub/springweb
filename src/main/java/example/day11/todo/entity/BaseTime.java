package example.day11.todo.entity;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

// 여러 엔티티들의 생성/수정 날짜(시간) 자동 주입 +관례적으로 레코드 생성/수정
@Getter // 롬복 getter
@MappedSuperclass // 엔티티 상속용도
// ++++ AppStart 클래스 위에 '@EnableJpaAuditing' 주입해야 가능하다 +++
// JPA가 데이터베이스를 모니터링(Auditing감시) 하여 엔티티가 변화되면 데이터베이스 변화 실행
@EntityListeners( AuditingEntityListener.class ) // 해당 엔티티를 자동 감시 적용
public class BaseTime {

    @CreatedDate // 현재 날짜/시간을 자동으로 주입
    private LocalDateTime createDate; // 생성날짜/시간
    // LocalDateTime --> datetime(6)

    @LastModifiedDate // 엔티티 변화 시점의 날짜/시간을 자동으로 주입
    private LocalDateTime updateDate; // 수정날짜/시간

}
