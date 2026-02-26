package example.day03.practice3;

import org.springframework.boot.jackson.autoconfigure.JacksonProperties;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.apache.logging.log4j.message.MapMessage.MapFormat.JSON;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {

    // 1. 출석 등록
    @PostMapping
    public boolean 출석등록(){
        System.out.println("AttendanceController.POST");
        return true;
    }

    // 2. 출석 전체 조회
    @GetMapping
    public List<AttendanceDto> 출석전체조회(){
        System.out.println("AttendanceController.GET");
        return list;
    }

    // 3. 출석 개별 조회
    @GetMapping("/detail")
    public AttendanceDto 출석개별조회(){
        System.out.println("AttendanceController.출석개별조회");
        return
    }
}
