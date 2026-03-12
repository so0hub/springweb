//package example.day06.practice6;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//public class MovieController {
//    @Autowired
//    private MovieService movieService;
//
//    // 영화 등록
//    // http://localhost:8080/movie
//    // BODY : { "title" : "박진감의 기묘한 모험" }
//    @PostMapping("/day06/practice6/")
//    public boolean 등록(@RequestBody MovieDto movieDto ){
//        boolean result = movieService.등록( movieDto );
//        return result;
//    }
//
//    // 영화 전체 조회
//    @GetMapping("/day06/practice6/")
//    public List< MovieDto > 영화전체조회(){
//        List<MovieDto> result = movieService.영화전체조회();
//        return result;
//    }
//
//    // 영화 개별 조회 ( 영화번호(movieid)를 기준으로 조회 )
//    @GetMapping("/day06/practice6/")
//    public List< MovieDto > 영화개별조회(){
//        MovieDto result = movieService.영화개별조회( 아 여기다가 뭐쓰지 띠ㅃ);
//        return result;
//    }
//
//    // 특정 영화 수정 ( 영화번호(movieid)를 기준으로 수정)
//    @PutMapping("/day06/practice6/")
//    public boolean 수정(@RequestBody MovieDto movieDto ){
//        boolean result = movieService.수정(movieDto);
//        return result;
//    }
//
//    // 특정 영화 삭제 ( 영화번호(movieid)를 기준으로 삭제 )
//    @DeleteMapping("/day06/practice6/")
//    public boolean 삭제(@RequestParam int movieid ){
//        boolean result = movieService.삭제(movieid);
//        return result;
//    }
//
//}
