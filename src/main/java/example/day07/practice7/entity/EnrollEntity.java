package example.day07.practice7.entity;

import example.day07.practice7.BaseTime;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@AllArgsConstructor @NoArgsConstructor @Data @Builder
@Entity @Table( name = "enroll" )
@EntityListeners(AuditingEntityListener.class) // 이걸 추가해야만 날짜가 자동으로 찍힌다!! 빼먹지라르르르르르렴
public class EnrollEntity extends BaseTime {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer enrollId; // 수강 번호;
    private String status; // 수강 상태

    // ** 단방향1 : 과정엔티티와 연결 **
    // 수강정보(N)는 과정(1)에 속한다
    @ManyToOne( cascade = CascadeType.ALL , fetch = FetchType.LAZY ) // 1 : M 다수가 하나에게
    @JoinColumn(name = "course_id") // FK // 데이터베이스에서는 cid와 조인 , 자바에서는 courseEntity 매핑
    private CourseEntity courseEntity;

    // ** 단방향2 : 학생 엔티티와 연결 **
    // 수강(N)은 학생(1)에 속한다
    @ManyToOne( cascade = CascadeType.ALL , fetch = FetchType.LAZY )
    @JoinColumn(name = "student_id")
    private StudentEntity studentEntity;
}
