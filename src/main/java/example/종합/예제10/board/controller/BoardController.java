package example.종합.예제10.board.controller;

import example.종합.예제10.board.dto.BoardDto;
import example.종합.예제10.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BoardController {
    @Autowired
    private BoardService boardService;

    // 1. 등록
    // http://localhost:8080/board
    // { "btitle" : "박진감의 기묘한 모험" ,"bcontent" : "테스트내용" , "bwriter" : "박진감" }
    @PostMapping("/board")
    public boolean 등록(@RequestBody BoardDto boardDto) {
        boolean result = boardService.등록(boardDto);
        return result;
    } // f END

    // 2. 전체 조회
    // http://localhost:8080/board
    @GetMapping("/board")
    public List<BoardDto> 전체조회() {
        List<BoardDto> result = boardService.전체조회();
        return result;

    }

    // 3. 개별 조회
    // http://localhost:8080/board/detail
    @GetMapping("/board/detail")
    public BoardDto 개별조회(@RequestParam int bno) {
        BoardDto result = boardService.개별조회(bno);
        return result;
    }

    // 4. 개별 수정
    // http://localhost:8080/board
    @PutMapping("/board")
    public boolean 개별수정(@RequestBody BoardDto boardDto) {
        return boardService.개별수정(boardDto);
    }

    // 5. 개별 삭제
    // http://localhost:8080/board
    @DeleteMapping("/board")
    public boolean 개별삭제(@RequestParam int bno) {
        boolean result = boardService.개별삭제(bno);
        return result;
    }



}
