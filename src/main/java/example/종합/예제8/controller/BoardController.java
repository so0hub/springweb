package example.종합.예제8.controller;
import example.종합.예제8.model.dao.BoardDao;
import example.종합.예제8.model.dto.BoardDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController // 해당 컨트롤러는 HTTP 기능 갖게 된다. < 싱글톤 유사 포함 >
public class BoardController {

    // * 싱글톤 지우기 !!!!! 왜냐면 @ 골뱅이 안에 싱글톤 역할이 포함되어있음!!!!!

    private BoardDao bd = BoardDao.getInstance();

    // [1] 게시물 등록 controller
    @PostMapping
    public boolean write(String bcontent , String bwriter ){
        boolean result = bd.write(bcontent , bwriter);
        return result;
    }

    // [2] 게시물 전체 조회 controller  , 여러개 레코드 조회 -> ArrayList , 한 개 레코드 조회 -> dto
    @GetMapping
    public ArrayList<BoardDto> findAll(){
        ArrayList<BoardDto> result = bd.findAll();
        return result;
    }
    // [3] 게시물 수정 controller
    @PutMapping
    public boolean update(int bno , String bcontent) {
        boolean result = bd.update(bno, bcontent);
        return result;
    }

    // [4] 게시물 삭제 controller
    @DeleteMapping
    public boolean delete(int bno){
        boolean result = bd.delete(bno);
        return result;
    }
} // class END
