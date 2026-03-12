package example.day06.practice6;


import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass // 엔티티 상속용 클래스 지정
@EntityListeners(AuditingEntityListener.class) // JPA 감사 기능 활성화
public class BaseTime {

    @CreatedDate // 엔티티 생성날짜/시간 주입
    private LocalDateTime createDate;

    @LastModifiedDate // 엔티티 생성날짜/시간 주입
    private LocalDateTime updateDate;

}
