package example.day07.practice7.controller;

import example.day07.practice7.dto.EnrollDto;
import example.day07.practice7.service.EnrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EnrollController {
    @Autowired
    private EnrollService enrollService;

    // 수강 정보 등록
    // http://localhost:8080/enroll
    // {"studentId": 1,"courseId": 1,"status": "수강신청완료"}
    @PostMapping("/enroll")
    public boolean 수강정보등록(@RequestBody EnrollDto enrollDto) {
        boolean result = enrollService.수강정보등록(enrollDto);
        return result;
    }

    // 수강 정보 조회: http://localhost:8080/enroll/1
    @GetMapping("/enroll/{enrollId}")
    public EnrollDto 수강정보조회(@PathVariable Integer enrollId) {
        return enrollService.수강정보조회(enrollId); // 서비스 호출
    }
}