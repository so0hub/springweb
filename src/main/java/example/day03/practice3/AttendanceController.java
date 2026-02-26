package example.day03.practice3;


import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/attendance")
public class AttendanceController {

    // 1. 출석 등록 http://localhost:8080/attendance , body :
    @PostMapping
    // "ano" 생략시 DTO에서 Int -> Integer 래퍼 클래스
    public boolean 출석등록(@RequestBody AttendanceDto attendanceDto){
        System.out.println("AttendanceController.출석등록"); // 확인 용도
        return true;
    }

    // 2. 출석 전체 조회 http://localhost:8080/attendance
    @GetMapping
    public List<AttendanceDto> 출석전체조회(){
        List<AttendanceDto> list = new ArrayList<>();
        list.add( new AttendanceDto(1,"박진감","2026-02-26","출석"));
        list.add( AttendanceDto.builder().status("출석").studentName("박소영").date("2026-02-26").ano(1).build());
        System.out.println("AttendanceController.출석전체조회");
        return list;
    }

    // 3. 출석 개별 조회 http://localhost:8080/attendance
    @GetMapping("/detail")
    public AttendanceDto 출석개별조회(){
        AttendanceDto attendanceDto = new AttendanceDto();
        System.out.println("AttendanceController.출석개별조회");
        return attendanceDto;
    }
}
