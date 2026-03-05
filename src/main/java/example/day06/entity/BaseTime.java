package example.day06.entity;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@MappedSuperclass // 엔티티의 상속용도 클래스
@Getter // 상속받은 엔티티가 멤버변수
public class BaseTime {

    private LocalDateTime createDate;

    private LocalDateTime updateDate;


}
