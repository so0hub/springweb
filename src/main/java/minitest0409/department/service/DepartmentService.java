package minitest0409.department.service;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import minitest0409.department.dto.DepartmentDto;
import minitest0409.department.entity.DepartmentEntity;
import minitest0409.department.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    // 부서 전체 조회
    public List<DepartmentDto> dpList(){
        List<DepartmentEntity> departmentEntityList = departmentRepository.findAll();
        List<DepartmentDto> departmentDtoList = new ArrayList<>();

        departmentEntityList.forEach(entity->{
            DepartmentDto departmentDto = new DepartmentDto();
            departmentDto.setDno(entity.getDno());
            departmentDto.setDname(entity.getDname());
            departmentDtoList.add(departmentDto);
        });
        return departmentDtoList;
    }

    // 부서 등록
    public boolean dpAdd(DepartmentDto departmentDto){
        DepartmentEntity departmentEntity = departmentDto.toEntity();
        DepartmentEntity savedEntity = departmentRepository.save( departmentEntity );

        if(savedEntity.getDno() >= 1)return true;
        return false;
    }

    // 부서 수정
    public DepartmentDto dpUpdate(Integer dno,DepartmentDto request){
       DepartmentEntity departmentEntity = departmentRepository.findById(dno).orElseThrow();
       departmentEntity.setDname(request.getDname());
       return departmentEntity.toDto();
    }

    // 부서 삭제
    public void dpDelete(Integer dno){
        DepartmentEntity department = departmentRepository.findById(dno).orElseThrow();
        departmentRepository.delete(department);
    }
}
