package example.day06.practice6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/day06/practice6")
public class MovieController {
    @Autowired
    private MovieService movieService;

    // 영화 등록
    // http://localhost:8080/movie
    // BODY : { "title" : "박진감의 기묘한 모험" }
    @PostMapping("")
    public boolean 등록(@RequestBody MovieDto movieDto ){
        return movieService.등록(movieDto);
    }

    // 영화 전체 조회
    @GetMapping("")
    public List< MovieDto > 영화전체조회(){
        return movieService.영화전체조회();
    }

    // 영화 개별 조회 ( 영화번호(movieid)를 기준으로 조회 )
    @GetMapping("/{movieid}")
    public MovieDto 영화개별조회(@PathVariable int movieid){
        return movieService.영화개별조회(movieid);
    }

    // 특정 영화 수정 ( 영화번호(movieid)를 기준으로 수정)
    @PutMapping("")
    public boolean 수정(@RequestBody MovieDto movieDto ){
        return movieService.수정(movieDto);
    }

    // 특정 영화 삭제 ( 영화번호(movieid)를 기준으로 삭제 )
    @DeleteMapping("")
    public boolean 삭제(@RequestParam int movieid ){
        return movieService.삭제(movieid);
    }

}
