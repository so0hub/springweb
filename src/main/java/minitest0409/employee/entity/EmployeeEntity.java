package minitest0409.employee.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import minitest0409.department.entity.DepartmentEntity;
import minitest0409.employee.dto.EmployeeDto;

@Entity
@Table(name="employee")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class EmployeeEntity {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Integer eno; // 사원번호

    @Column( nullable = false, length = 10 , unique = true )
    private String ename; // 사원이름

    @Column( nullable = false,length = 10 )
    private String erank; // 직급

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="department_no")
    private DepartmentEntity departmentEntity;

    // Entity --> Dto , 주로 조회할 때 사용
    public EmployeeDto toDto(){
        return EmployeeDto.builder()
                .eno(eno)
                .ename(ename)
                .erank(erank)
                .build();
    }
}
