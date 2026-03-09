package example.day07.practice7.dto;

import example.day07.practice7.entity.StudentEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class StudentDto {
    private Integer studentId; // 학생 번호
    private String studentName; // 학생명
    // + baseTime
    private String createDate;
    private String updateDate;

    // ** DTO --> ENTITY 변환함수 **
    public StudentEntity stoEntity(){
        return StudentEntity.builder()
                .studentId(this.studentId)
                .studentName(this.studentName)
                .build();
    }
}
