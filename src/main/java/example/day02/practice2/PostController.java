package example.day02.practice2;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController // 빈 등록(싱글톤 대용) + HTTP 통신 기능 포함(view화면 반환) + ResponseBody 포함(값JSON 반환)
@RequestMapping("/practice2") // 해당 컨트롤러 내 메소드들이 사용하는 공통 URL 정의한다.
public class PostController {
    // [문제1 요구사항] 게시판 RestController 만들기1

    //1. AppStart 클래스 생성

    //2. PostController 클래스 생성

    //3. 각 URL 매핑 만들기

    //1. 글쓰기 POST "/practice2/post"
    @PostMapping("/post")
    public boolean POST(){
        return true;
    }
    // 매개변수 연결된 중매해주는 수, 호출하는 사람으로부터 받은 값
    //요청자료(클라이언트가 서버에게 요청하는 것) : x , 응답자료(서버가 클라이언트에게 다시 보내는 것) : true/false

    //2. 전체 글 조회 GET "/practice2/post"
    //요청자료 : x , 응답자료 : 임의의 List 타입 , [ {pno:'',ptitle:''} , {pno:'',ptitle:''} ]
    @GetMapping("/post")
    public List<Post> GET(){
        return [ {pno:'',ptitle:''} , {pno:'',ptitle:''} ];
    }

    //3. 개별 글 조회 GET "/practice2/post/view"
    //요청자료 : x , 응답자료 : 임의의 MAP 타입 , {pno:'',ptitle:''}

    //4. 개글 글 수정 PUT "/practice2/post"
    //요청자료 : x , 응답자료 : true 또는 false

    //5. 개별 글 삭제 DELETE "/practice2/post"

    //요청자료 : x , 응답자료 : 임의의 삭제한 번호 , 3

    //샘플 예1]
    //List<Map<String,String>> list = new ArrayList<>();
    //Map<String,String> map1 = new HashMap<>();
    //map1.put("bno" , "1" );
    //map1.put("btitle" , "제목1");
    //list.add( map1 );
    //Map<String,String> map2 = new HashMap<>();
    //map2.put("bno" , "2" );
    //map2.put("btitle" , "제목2");
    //list.add( map2 );

    //샘플 예2]
    //Map<String,String> map1 = new HashMap<>();
    //map1.put("bno" , "1" );
    //map1.put("btitle" , "제목1");
    //[문제2 요구사항] 게시판 RestController 만들기2
    //https://docs.google.com/spreadsheets/d/1xEByWi1DLDDdoyxc3KOUhprNqWYk8jwBJAOrDG0Gi_U/edit?usp=sharing
    //1. AppStart 클래스 생성
    //2. BoardController 클래스 생성
    //3. 위 링크에 명세서API 에 따라서 BoardController 코드를 완성
}
