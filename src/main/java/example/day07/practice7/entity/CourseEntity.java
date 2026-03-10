package example.day07.practice7.entity;

import example.day07.practice7.BaseTime;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor @NoArgsConstructor @Data @Builder
@Entity @Table( name = "course" )
public class CourseEntity extends BaseTime {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Integer courseId; // 과정번호
    private String courseName; // 과정명

        // 과정(1) : 수강기록(N) - 양방향 : 단순히 조회 용도로만 쓰는 것임.
        @OneToMany(mappedBy = "courseEntity")
        @ToString.Exclude // 양방향할 때 주의할 점 꼭 한 군데에는 투스트링 익스클루드 이거 쓰기
        @Builder.Default
        private List<EnrollEntity> enrollEntityList = new ArrayList<>();
    }
