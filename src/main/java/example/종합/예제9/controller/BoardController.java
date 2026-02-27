package example.종합.예제9.controller;

import example.종합.예제9.dao.BoardDao;
import example.종합.예제9.dto.BoardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // 빈 등록 + HTTP 기능 + HTTP 응답객체
public class BoardController {

    @Autowired // 의존성 주입 : 등록된 빈(객체) 가져오기
    private BoardDao boardDao;

    // 1) 전체 조회
    @GetMapping("/board") // localhost:8080/board           // 1) 해당 메소드의 HTTP 메소드와 주소 정의
    public List<BoardDto> findAll(){                        // 2) 매개변수 정의 *현재없음
        List<BoardDto> result = boardDao.findAll();         // 3) DAO 호출하여 결과 받기
        return result;                                      // 4) DAO 결과로 응답하기
    }

    // 2) 게시물 등록 http://localhost:8080/board , BODY : { "bcontent": "테스트내용", "bwriter": "유재석"}
    @PostMapping("/board")
    public boolean write(@RequestBody BoardDto boardDto){
        boolean result = boardDao.write(boardDto);
        return result;
    }

    // 3] 게시물 개별 수정
    @PutMapping("/board")
    public boolean update( @RequestBody BoardDto boardDto ){
        boolean result =  boardDao.update( boardDto );
        return result;
    }

    // 4] 게시물 개별 삭제 http://localhost:8080/board?bno=
    @DeleteMapping("/board")
    public boolean delete( @RequestParam int bno){
        boolean result = boardDao.delete(bno);
        return result;
    }

}


