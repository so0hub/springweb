package minitest0409.department.controller;


import lombok.RequiredArgsConstructor;
import minitest0409.department.dto.DepartmentDto;
import minitest0409.department.service.DepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/dp")
@CrossOrigin(value="http://localhost:5173")
public class DepartmentController {

    private final DepartmentService departmentService;

    // 부서 전체 조회
    // http://localhost:8080/api/dp/list
    @GetMapping("/list")
    public List<DepartmentDto> dpList(){
        List<DepartmentDto> result = departmentService.dpList();
        return result;
    }

    // 부서 등록
    // http://localhost:8080/api/dp/add
    @PostMapping("/add")
    public boolean dpAdd(@RequestBody DepartmentDto departmentDto){
        boolean result = departmentService.dpAdd(departmentDto);
        return result;
    }

    // 부서 수정
    // http://localhost:8080/api/dp/update
    @PutMapping("/update")
    public ResponseEntity<?> dpUpdate(@RequestParam Integer dno, @RequestBody DepartmentDto request){
        return ResponseEntity.ok(departmentService.dpUpdate(dno,request));
    }

    // 부서 삭제
    // http://localhost:8080/api/dp/delete
    @DeleteMapping("/delete")
    public ResponseEntity<?> dpDelete(@RequestParam Integer dno){
        departmentService.dpDelete(dno);
        return ResponseEntity.noContent().build();

        // taskCont
    }

}
