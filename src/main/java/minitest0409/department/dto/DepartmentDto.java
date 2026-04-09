package minitest0409.department.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import minitest0409.department.entity.DepartmentEntity;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class DepartmentDto {
    private Integer dno; // 부서번호
    private String dname; // 부서명

    // DTO --> ENTITY , 주로 저장/수정
    public DepartmentEntity toEntity(){
        return DepartmentEntity.builder()
                .dname(dname)
                .build();
    }
}
