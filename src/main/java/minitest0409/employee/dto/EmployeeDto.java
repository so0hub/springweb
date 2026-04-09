package minitest0409.employee.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import minitest0409.employee.entity.EmployeeEntity;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class EmployeeDto {
    private Integer eno; // 사원번호
    private String ename; // 사원이름
    private String erank; // 직급

    // DTO --> ENTITY , 주로 저장/수정
    public EmployeeEntity toEntity(){
        return EmployeeEntity.builder()
                .ename(ename)
                .erank(erank)
                .build();
    }
}
