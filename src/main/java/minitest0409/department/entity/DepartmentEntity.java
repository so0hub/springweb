package minitest0409.department.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import minitest0409.department.dto.DepartmentDto;
import minitest0409.employee.entity.EmployeeEntity;

@Entity
@Table(name="department")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class DepartmentEntity {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Integer dno; // 부서번호

    @Column( nullable = false , length = 20 , unique = true )
    private String dname; // 부서명

//    // 사원 번호(FK)
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name="eno")
//    private EmployeeEntity employeeEntity;

    // Entity --> Dto , 주로 조회
    public DepartmentDto toDto(){
        return DepartmentDto.builder()
//                .eno(this.employeeEntity.getEno())
                .dno(dno)
                .dname(dname)
                .build();
    }
}
