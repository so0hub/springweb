package example.day07.practice7;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor @NoArgsConstructor @Data @Builder
@Entity @Table( name = "enroll" )
public class EnrollEntity extends BaseTime {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer enrollId; // 수강 번호;
    private String status; // 수강 상태


    // 수강(N)은 과정(1)에 속한다
    @ManyToOne // 1 : M 다수가 하나에게
    @JoinColumn(name = "course_id")
    private CourseEntity courseEntity;

    // 수강(N)은 학생(1)에 속한다
    @ManyToOne
    @JoinColumn(name = "student_id")
    private StudentEntity studentEntity;
}
