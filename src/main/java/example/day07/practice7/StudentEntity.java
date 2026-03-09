package example.day07.practice7;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor @NoArgsConstructor @Data @Builder
@Entity @Table( name = "student" )
public class StudentEntity extends BaseTime {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Integer studentId; // 학생번호 // PK
    private String studentName; // 학생명

    // 단방향
    @ManyToOne // 다수가 하나에게 , 1:M , 하나의 과정에 여러 학생 참조
    @JoinColumn( name = "courseId" )
    private CourseEntity courseEntity;

    // 양방향
    @OneToMany( mappedBy = "studentEntity" ) // 하나가 다수에게 , 1 : M
    @ToString.Exclude // 순환참조 방지
    @Builder.Default // new 생성자 대신에 빌더로 객체 생성시 초기값 사용
    private List<EnrollEntity> enrollEntityList = new ArrayList<>();
}
