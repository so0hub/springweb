package example.day11.todo.controller;

import example.day11.todo.dto.TodoDto;
import example.day11.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor // final 멤버변수 생성자 제공
@RequestMapping("/api/todo")
public class TodoController {
    private final TodoService todoService;

    // 1. 전체조회 //  http://localhost:8080/api/todo
    @GetMapping("")
    public ResponseEntity<?> findAll(){
        List<TodoDto> result = todoService.findAll();
        return ResponseEntity.status(200).body(result);
        // HTTP 응답코드 200 또는 ok (성공의미)
    }
    // ResponseEntity : 응답객체 , 사용목적 : 응답값 외 추가적인 자료 포함 <응답코드>
    // <> : 제네릭 , < ? > 제네릭에 ? 타입 사용시 Object 와 동일하게 모든 타입 대입 가능하다.
    // ResponseEntity<Integer> : Integer 타입만 반환
    //  ResponseEntity<?> : 모든 타입 반환


    // 2. 개별조회
    @GetMapping("/detail") //  http://localhost:8080/api/todo/detail?id=3
    public ResponseEntity< ? > findById( @RequestParam int id ){
        TodoDto result = todoService.findById(id);
        return ResponseEntity.status(200).body(result);
    }

    // 3. title 개별 조회
    @GetMapping("/query1") // http://localhost:8080/api/todo/query1?title=자바 공부
    public ResponseEntity<?> query1( @RequestParam String title ){
        TodoDto result = todoService.query1( title );
        return ResponseEntity.ok(result); // ok도 성공이라는 뜻
    }


    // 4. title 과 content 개별 조회
    @GetMapping("/query2") // http://localhost:8080/api/todo/query1?title=자바 공부&content=JPA 기본 개념 정리
    public ResponseEntity<?> query2(
            @RequestParam String title,
            @RequestParam String content ){
            Map<String,Object> result =
            todoService.query2(title,content);
            return ResponseEntity.status(200).body(result);
    }

    // 5. title 이 포함된 개별 조회
    @GetMapping("/query3") // http://localhost:8080/api/todo/query1?title=실습
    public ResponseEntity<?> query4(@RequestParam String title){
        List<TodoDto> result = todoService.query3(title);
        return ResponseEntity.status(200).body(result);
    }

    // 6. 페이징처리 // http://localhost:8080/api/todo/page?page=1&size=3
    @GetMapping("/page")
    public ResponseEntity<?> page( @RequestParam int page , // page 는 조회할 현재페이지 번호 뜻
                                @RequestParam int size ){ // size 는 페이지당 조회할 엔티티 개수
        return ResponseEntity.ok(todoService.page(page,size));
    }

    // 7. 페이징처리2
    @GetMapping("/page2") // http://localhost:8080/api/todo/page2?keyword=공&page=1&size=3
    public ResponseEntity<?> page2(@RequestParam String keyword , // 검색어
                                   @RequestParam (defaultValue = "1") int page,
                                   @RequestParam (defaultValue = "3") int size ){
        // defaultVaule 는 쿼리스트링 값이 존재하지 않으면 초기값

        return ResponseEntity.ok( todoService.page2(keyword,page,size));

    }


} // class END
