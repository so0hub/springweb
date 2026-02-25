package example.day02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // HTTP 기능 + 빈 등록
public class RestController2 {

    // 1. 100 반환하는 메소드
    @GetMapping("/day02/task") // was(톰캣)주소/내가정의한주소, localhost:8080/day02/task
    @ResponseBody // Response(응답) Body(객체지향) : 응답 자료 자동 타입 변환,
    // java(객체지향) <--번역--> HTTP(문자) , JAVA는 INT를 반환하겠다고 하지만 HTTP는 INT 모른다.
    // 즉] JAVA 타입을 자동으로 HTTP contents Type 변환해준다. int -> application/json
    public int method1(){
        System.out.println("RestController2.method1");
        return 100;
    }
}