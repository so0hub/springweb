package minitest0409.employee.controller;

import lombok.RequiredArgsConstructor;
import minitest0409.employee.dto.EmployeeDto;
import minitest0409.employee.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/ep")
@CrossOrigin(value="http://localhost:5173")
public class EmployeeController {

    private final EmployeeService employeeService;

    // 사원 전체 조회
    @GetMapping("/list")
    // http://localhost:8080/api/ep/list
    public List<EmployeeDto> epList(){
        List<EmployeeDto> result = employeeService.epList();
        return result;
    }

    // 사원 등록
    // http://localhost:8080/api/ep/add
    @PostMapping("/add")
    public boolean epAdd(@RequestBody EmployeeDto employeeDto){
        boolean result = employeeService.epAdd(employeeDto);
        return result;
    }

    // 특정 사원 수정
    // http://localhost:8080/api/ep/update
    @PutMapping("/update")
    public boolean epUpdate(@RequestBody EmployeeDto employeeDto){
        boolean result = employeeService.epUpdate(employeeDto);
        return result;
    }

    // 특정 사원 삭제
    // http://localhost:8080/api/ep/delete
    @DeleteMapping("/delete")
    public boolean epDelete(@RequestParam Integer eno){
        boolean result = employeeService.epDelete(eno);
        return result;
    }



}
