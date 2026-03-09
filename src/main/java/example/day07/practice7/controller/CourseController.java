package example.day07.practice7.controller;

import example.day07.practice7.service.CourseService;
import example.day07.practice7.dto.CourseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
    @Autowired
    private CourseService courseService;

    // 과정 정보 등록
    // http://localhost:8080/course
    // {"courseName" : "박진감키우기"}
    @PostMapping("/course")
    public boolean 과정정보등록(@RequestBody CourseDto courseDto ){
        boolean result = courseService.과정정보등록( courseDto );
        return result;
    }
}
