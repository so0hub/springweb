package example.day05.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExamController {
    @Autowired
    private ExamService examService;

    // R : 조회 select
    // http://localhost:8080/day05/exam
    @GetMapping("/day05/exam")
    public List< ExamDto > 전체조회(){
        List< ExamDto > result = examService.전체조회();
        return result;
    }

    // C : 쓰기 insert
    // http://localhost:8080/day05/exam
    // BODY : {"ename" : "정란희"}
    // 그 다음 다시 GET으로 조회하면 들어온 거 확인 가능
    @PostMapping("/day05/exam")
    public boolean 저장( @RequestBody ExamDto examDto ){
        boolean result = examService.저장( examDto );
        return result;
    }

    // D : 삭제 delete
    // http://localhost:8080/day05/exam?eno=1
    @DeleteMapping("/day05/exam")
    public boolean 삭제(@RequestParam int eno){
        boolean result = examService.삭제(eno);
        return result;
    }


    // U : 수정 update
    // http://localhost:8080/day05/exam
    // BODY : { "eno" : 2 , "ename" : "박진감2" }
    @PutMapping("/day05/exam")
    public boolean 수정( @RequestBody ExamDto examDto ){
        boolean result = examService.수정(examDto);
        return result;
    }







}

