package example.day11.todo.controller;

import example.day11.todo.dto.TodoDto;
import example.day11.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor // final 멤버변수 생성자 제공
@RequestMapping("/api/todo")
public class TodoController {
    private final TodoService todoService;

    // 1. 전체조회
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
} // class END
