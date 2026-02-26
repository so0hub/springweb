package example.day02.practice2;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController // 무조건 작성해야된다제
public class BoardController {

    // 1.
    @PostMapping
    public boolean boardWrite( BoardDto boardDto ){
        // dao 호출 생략하고 임의ㅡ이 값으로 연습 중
        return true; // 임의값

    }

    // 2.
    @GetMapping
    public ArrayList<BoardDto> boardPrint(@RequestBody int bno){
        // dao 호출 생략
        ArrayList<BoardDto> list = new ArrayList<>();
        BoardDto boardDto1 = new BoardDto(1, "내용1", "작성자1");
        BoardDto boardDto2 = new BoardDto(2, "내용1", "작성자1");
        list.add(boardDto1); list.add(boardDto2);
        return list;
    }
    // 3.
    @GetMapping("/detail")
    public BoardDto boardDetail(@RequestParam int bno){
        BoardDto boardDto = new BoardDto(1,"내용1","작성자1");
        return boardDto;
    }

    // 4.
    @DeleteMapping
    public boolean boardDelete(@RequestParam int bno){
        return false;
    }

    // 5.
    @PutMapping
    public boolean boardUpdate(@RequestBody BoardDto boardDto){
        return true;
    }
}
