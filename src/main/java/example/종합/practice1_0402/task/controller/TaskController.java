package example.종합.practice1_0402.task.controller;


import example.종합.practice1_0402.task.dto.TaskDto;
import example.종합.practice1_0402.task.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor // final 멤버변수 생성자
@RequestMapping("/api/task") // 리액트 경로 = /~~ vs 스프링 경로 = /api/~~ 중복될 수 있으므로 구분한다.
@CrossOrigin(origins = "http://localhost:5173") // 서로 다른 port(프로그램식별번호) 간의 통신 허용
// SOP 정책으로 서로 다른 도메인은 통신이 불가능하다. HTTP 보안 정책
// CORS : 교차 출처 리소스 공유, 즉] 서로 다른 도메인(8080스프링,5173리액트) 통신공유허용)
public class TaskController {
    private final TaskService taskService;

    // [1] 등록
    // http://localhost:8080/api/task
    // { "title": "공문 작성","content": "영수증 첨부","requester" : "유환빈","status" : "요청"}
    @PostMapping
    public ResponseEntity<?> taskPost(@RequestBody TaskDto taskDto){
        return ResponseEntity.ok(taskService.taskPost(taskDto));
    }

    // [2] 전체조회
    // http://localhost:8080/api/task
    @GetMapping
    public ResponseEntity<?> taskList(){
        return ResponseEntity.ok(taskService.taskList());
    }

    // [3] 업무 요청 상세 조회
    // http://localhost:8080/api/task/detail?id=1
    @GetMapping("/detail")
    public ResponseEntity<?> getTaskDetail(@RequestParam Integer id) {
        return ResponseEntity.ok(taskService.getTaskDetail(id));
    }

    // [4] 업무 요청 수정
    // http://localhost:8080/api/task?id=1
    // {"title" : "제목","content" : "내용","status" : "상태"}
    @PutMapping
    public ResponseEntity<?> updateTask(@RequestParam Integer id, @RequestBody TaskDto request) {
        return ResponseEntity .ok(taskService.updateTask(id, request));
    }

    // [5] 업무 요청 삭제
    // http://localhost:8080/api/task?id=1
    @DeleteMapping
    public ResponseEntity<?> delete(@RequestParam Integer id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }

}
