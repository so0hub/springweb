package example.day02.practice2;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController // 무조건 작성해야된다제
@RequestMapping("/board")
public class BoardController {

    // 1. http://localhost:8080/board , Body : { "bno" : 1 , "bcontent" : "안녕하세요", "bwriter" : "유재석"}
    @PostMapping
    public boolean boardWrite( @RequestBody BoardDto boardDto ){ // @RequestParam vs @RequestBody
        return true; // dao 호출 생략 하고 임의의 값으로 연습중
    }
    // 2.http://localhost:8080/board
    @GetMapping
    public ArrayList<BoardDto> boardPrint( ){
        ArrayList<BoardDto> list = new ArrayList<>();
        BoardDto boardDto1 = new BoardDto( 1 , "내용1" ,"작성자1");
        BoardDto boardDto2 = new BoardDto( 2 , "내용2" ,"작성자2");
        list.add( boardDto1 ); list.add( boardDto2 );
        return list; // // dao 호출 생략 하고 임의의 값으로 연습중
    }
    // 3. http://localhost:8080/board/detail?bno=1
    @GetMapping("/detail")
    public BoardDto boardDetail( @RequestParam int bno ){
        BoardDto boardDto = new BoardDto( 1 , "내용1" ,"작성자1");
        return boardDto; // // dao 호출 생략 하고 임의의 값으로 연습중
    }
    // 4. http://localhost:8080/board?bno=1
    @DeleteMapping
    public boolean boardDelete(  @RequestParam  int bno ){
        return false; // dao 호출 생략 하고 임의의 값으로 연습중
    }
    // 5. http://localhost:8080/board , Body : { "bno" : 1, "bcontent" : "안녕하세요2"}
    @PutMapping
    public boolean boardUpdate( @RequestBody BoardDto boardDto ){ // @RequestParam vs @RequestBody
        return true; // dao 호출 생략 하고 임의의 값으로 연습중
    }
    // 장점 : 틀(정해진 규칙 명확), 단점 : 자유도 떨어짐
}
