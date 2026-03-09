package example.day07.practice7.controller;

import example.day07.practice7.dto.StudentDto;
import example.day07.practice7.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    // 학생 정보 등록
    // http://localhost:8080/student
    // {"studentName" : "박진감"}
    @PostMapping("/student")
    public boolean 학생정보등록(@RequestBody StudentDto studentDto){
        boolean result = studentService.학생정보등록( studentDto );
        return result;
    }
}
