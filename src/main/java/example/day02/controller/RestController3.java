package example.day02.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

// @Component // 빈 등록(싱글톤 대용)
// @Controller // + HTTP 통신 기능 포함   = 사용처 : view(화면) 반환
@RestController // + ResPonseBody 포함   = 사용처 : 값(JSON) 반환
@RequestMapping("/day02") // @RequestMapping("/공통URL") 해당 컨트롤러 내 메소드들이 사용하는 공통 URL 정의한다.

public class RestController3 {
    // 1. 클래스가 @RestController 이므로 @ResponseBody 생략해도 된다.
    @GetMapping("/task6") // * 클래스가 @RequestMapping("/공통URL") 가지므로 localhost:8080/day02/task6
    public String method1(){return "서버에게 받은 메시지";}

    // 2. http://localhost:8080/day02/task7?name=유재석&age=40
    @GetMapping("/task7") // 쿼리스트링이란? URL(웹주소) 뒤로 ? 작성 후 매개변수명1=값&매개변수명2=값
    public int method2( @RequestParam String name , @RequestParam int age ){ // 쿼리스트링매개변수명 == 메소드매개변수명
        // @RequestParam 이란? URL(웹주소) 안에 포함된 쿼리스트링 매개변수 값 가져오는 어노테이션 / 생략 가능
        System.out.println("RestController3.method2"); // soutm : 메소드명 출력 자동완성 *
        System.out.println("name = " + name + ", age = " + age); // soutp : 메소드 매개변수 자동완성 *
        return 3;
    }
    // 그냥 task7로 통신하면 안 됨. task7?name=유재석&age=40 로 통신해야 성공

    // 3. http://localhost:8080/day02/task8?name=유재석&age=40
    @GetMapping("/task8")
    // 만약에 쿼리스트링의 매개변수명과 자바의 매개변수명이 다르면 @RequestParam( name = "쿼리스트링매개변수명")
    // 만약에 쿼리스트링의 매개변수명을 필수로 하지 않을 경우 @RequestParam( required = false ) , 기본값은 true
    public int method3( @RequestParam( required = false ) String name , @RequestParam( name = "age") int 나이 ){
        System.out.println("RestController3.method3");
        System.out.println("name = " + name + ", 나이 = " + 나이);
        return 8; // 리턴값 아무의미없음 아무거나 넣은 것
    }

    // 4. http://localhost:8080/day02/task9?name=유재석
    @DeleteMapping("/task9") // GET/DELETE 메소드는 구조와 사용법이 동일하다.
    public int method4( String name , @RequestParam( defaultValue = "19") int age ){
        // 만약에 @RequestParam 생략해도 매개변수 매핑(연결) 가능하다.
        // 만약에 쿼리스트링에 존재하지 않을 때 기본값으로 설정하기 , @RequestParam( defaultValue="초기값" )
        System.out.println("RestController3.method4");
        System.out.println("name = " + name + ", age = " + age);
        return 9;
    }

    // 5. http://localhost:8080/day02/task10?name=유재석&age=40
    @DeleteMapping("/task10") // 여러개 매개변수를 하나의 Map 타입으로 받을 수 있다.
    public int method5( @RequestParam Map<String,Object> map ){
        System.out.println("RestController3.method5");
        System.out.println("map = " + map); // map = {name=유재석, age=40}
        return 13;
    }

    // 6. http://localhost:8080/day02/task11?name=유재석&age=40
    @PostMapping("/task11")
    public int method5( @ModelAttribute ExamDto examDto ){
        System.out.println("RestController3.method5");
        System.out.println("examDto = " + examDto);
        return 0;
    }
    // 즉] URL?매개변수=값 방식인 쿼리스트링은 URL 상 매개변수 노출이 된다.
    // GET/DELETE -> 쿼리스트링 -> @RequestParam/@ModelAttribute
    // POST/PUT -> 쿼리스트링/BODY 본문 -> @RequestBody
    // 즉2] URL 상의 매개변수 노출이 가리기 위한 BODY(본문) 사용하자.
    // 노출이 되면 안되는 개인정보/패스워드/민감한 정보들은 POST/PUT BODY(본문)을 사용하자.
    // 예시] 편지의 편지봉투 = 쿼리스트링 , 편지의 내용물(편지지) = BODY

    // 7. http://localhost:8080/day02/task12
    // BODY : {"name" : "유재석","age" : 40}
    // HTML --> JS --> JAVA(controller -> dao)
    @PostMapping("/task12")
    public int method12( @RequestBody ExamDto examDto ){
        System.out.println("RestController3.method12");
        System.out.println("examDto = " + examDto);
        return 0;
    }

    // 8. http://localhost:8080/day02/task13
    @PutMapping("/task13")  // BODY : {"name" : "유재석","age" : 40}
    public int method13( @RequestBody Map<String,Object> map){
        System.out.println("RestController3.method13");
        System.out.println("map = " + map);
        return 13;
    }

} // class END
