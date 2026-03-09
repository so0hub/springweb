package example.day07.practice7.dto;

import example.day07.practice7.entity.CourseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor @Data @Builder
public class CourseDto {
    private Integer courseId; // 과정 번호
    private String courseName; // 과정명
    // + baseTime
    private String createDate;
    private String updateDate;

    // ** DTO --> ENTITY 변환함수 **
    public CourseEntity toEntity(){
        return CourseEntity.builder()
                .courseId(this.courseId)
                .courseName(this.courseName)
                .build();
    }


}
