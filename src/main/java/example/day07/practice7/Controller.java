package example.day07.practice7;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Autowired
    private Service service;

    // 과정 정보 등록
    // http
    // {"courseName" : "박진감키우기"}
    @PostMapping("/study")
    public boolean 과정정보등록(@RequestBody StudyDto studyDto ){
        boolean result = Service.과정정보등록( studyDto );
        return result;
    }
}
