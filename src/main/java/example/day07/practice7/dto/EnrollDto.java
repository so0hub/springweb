package example.day07.practice7.dto;

import example.day07.practice7.entity.EnrollEntity;
import example.day07.practice7.entity.StudentEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class EnrollDto {
    private Integer enrollId; // 학생 번호
    private String enrollName; // 학생명
    // + baseTime
    private String createDate;
    private String updateDate;

    // ** DTO --> ENTITY 변환함수 **
    public EnrollEntity enrollEntity (){
        return EnrollEntity.builder()
                .enrollId(this.enrollId)
                .enrollName(this.enrollName)

                .build();
    }
}
