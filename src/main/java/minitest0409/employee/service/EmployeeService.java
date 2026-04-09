package minitest0409.employee.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import minitest0409.employee.dto.EmployeeDto;
import minitest0409.employee.entity.EmployeeEntity;
import minitest0409.employee.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    // 사원 전체 조회
    public List<EmployeeDto> epList(){
        List<EmployeeEntity> employeeEntityList = employeeRepository.findAll();
        List<EmployeeDto> employeeDtoList = new ArrayList<>();

        employeeEntityList.forEach(entity->{
            EmployeeDto employeeDto = new EmployeeDto();
            employeeDto.setEno(entity.getEno());
            employeeDto.setEname(entity.getEname());
            employeeDto.setErank(entity.getErank());
            employeeDtoList.add(employeeDto);
        });
        return employeeDtoList;
    }

    // 사원 등록
    public boolean epAdd(EmployeeDto employeeDto ){
        EmployeeEntity  employeeEntity = employeeDto.toEntity(); // dto --> entity 변환한다.
        EmployeeEntity savedEntity = employeeRepository.save( employeeEntity );

        if(savedEntity.getEno() >= 1) return true;
        return false;
    }

    // 특정 사원 수정
    public boolean epUpdate(EmployeeDto employeeDto){
        Optional<EmployeeEntity> optional
                =employeeRepository.findById(employeeDto.getEno());

        if(optional.isPresent()){
            EmployeeEntity employeeEntity = optional.get();
            employeeEntity.setEname(employeeDto.getEname());
            employeeEntity.setErank(employeeDto.getErank());

            return true;
        }
        return false;
    }

    // 특정 사원 삭제
    public boolean epDelete(Integer eno){
        employeeRepository.deleteById(eno);
        return true;
    }

}
