package example.day07.practice7.controller;

import example.day07.practice7.dto.EnrollDto;
import example.day07.practice7.service.EnrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnrollController {
    @Autowired
    private EnrollService enrollService;

    // 수강 정보 등록
    // http://localhost:8080/enroll
    // {"enrollName" : "박진감의 기묘한 모험"}
    @PostMapping("/enroll")
    public boolean 수강정보등록(@RequestBody EnrollDto enrollDto){
        boolean result = enrollService.수강정보등록(enrollDto);
        return result;
    }
}
