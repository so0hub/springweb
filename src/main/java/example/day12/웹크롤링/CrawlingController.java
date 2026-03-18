package example.day12.웹크롤링;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/craw")
public class CrawlingController {
    private final CrawlingService crawlingService;


    // [1]
    @GetMapping("/test1") // http://localhost:8080/api/craw/test1
    public ResponseEntity<?> test1(){
        return ResponseEntity.ok( crawlingService.test1() );
    }

    // [2]
    @GetMapping("/test2") // http://localhost:8080/api/craw/test2
    public ResponseEntity<?> test2(){
        return ResponseEntity.ok( crawlingService.test2() );
    }

}

