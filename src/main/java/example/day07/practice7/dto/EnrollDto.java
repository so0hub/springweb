package example.day07.practice7.dto;

import example.day07.practice7.entity.EnrollEntity;
import example.day07.practice7.entity.StudentEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class EnrollDto {
    private Integer enrollId; // 수강 번호;
    private String status; //  수강 상태
    // + baseTime
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    // + 학생
    private String studentName;
    private Integer studentId;
    // + 과정
    private String courseName;
    private Integer courseId;

    // ** DTO --> ENTITY 변환함수 **
    public EnrollEntity etoEntity (){
        return EnrollEntity.builder()
                .enrollId(this.enrollId)
                .status(this.status)
                .build();
    }
}
