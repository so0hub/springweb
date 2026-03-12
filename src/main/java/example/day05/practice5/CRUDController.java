package example.day05.practice5;

import example.day05.mvc.ExamDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CRUDController {
    @Autowired
    private CRUDService crudService;

    // 도서 전체 조회
    // http://localhost:8080/day05/practice5
    @GetMapping("/day05/practice5")
    public List< CRUDDto > 전체조회(){
        List< CRUDDto > result = crudService.전체조회();
        return result;
    }

    // 도서 등록
    // http://localhost:8080/day05/practice5
    // BODY : {"bname" : "책 먹는 박진감" }
    @PostMapping("/day05/practice5")
    public boolean 등록(@RequestBody CRUDDto crudDto ){
        boolean result = crudService.등록( crudDto );
        return result;
    }

    // 특정 도서 삭제 delete
    // http://localhost:8080/day05/practice5?bno=1
    @DeleteMapping("/day05/practice5")
    public boolean 삭제(@RequestParam int bno){
        boolean result = crudService.삭제(bno);
        return result;
    }

    // 특정 도서 수정 update
    // http://localhost:8080/day05/practice5
    @PutMapping("/day05/practice5")
    public boolean 수정( @RequestBody CRUDDto crudDto ) {
        boolean result = crudService.수정(crudDto);
        return result;
    }

}
