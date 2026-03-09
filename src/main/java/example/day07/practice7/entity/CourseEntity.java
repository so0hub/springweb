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
    private Integer courseId; // 과정번호 // PK
    private String courseName; // 과정명

        // 과정(1) : 수강기록(N) - 양방향
        @OneToMany(mappedBy = "courseEntity")
        @ToString.Exclude @Builder.Default
        private List<EnrollEntity> enrollEntityList = new ArrayList<>();
    }
