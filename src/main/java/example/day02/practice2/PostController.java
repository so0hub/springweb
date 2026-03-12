package example.day02.practice2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// @Component // (1) 싱글톤 대신에 스프링컨테이너 빈(객체) 등록
// @Controller // + (2) HTTP 기능(GET/POST/PUT/DELETE)
// @ResponseBody // + (3) HTTP 응답 Content-Type 자동 설정
@RestController // @Controller(+@Component) + @ResponseBody // 빈 등록(싱글톤 대용) + HTTP 통신 기능 포함(view화면 반환) + ResponseBody 포함(값JSON 반환)
@RequestMapping("/practice2/post") // 해당 컨트롤러 내 메소드들이 사용하는 공통 URL 정의한다. // 요청 연결  // vs // @RequestParam // 요청 파라미터 ( 파람 : 매개변수 )
public class PostController {

    /*
        메소드 란?  : 상호작용(주고받는 쌍방향 행동)
            매개변수? 매개(중개)변수(정해져있지않는값) : 메소드가 호출될 때 들어오는 값 (인수)
            반환값? 메소드가 종료될 때 호출했던 곳으로 반환해주는 값 (리턴)
        HTTP 이란? 상호작용( request / response )
            request? 클라이언트가 서버로부터 요청
            response? 서버가 처리한 결과를 클라이언트에 반환/응답
     */
    // [문제1 요구사항] 게시판 RestController 만들기1

    //1. AppStart 클래스 생성

    //2. PostController 클래스 생성

    //3. 각 URL 매핑 만들기

    //1. 글쓰기 POST http://localhost:8080/practice2/post
    @PostMapping // 추가할 url없으면 이렇게 비워놔도 된다제
    // localhost = 내컴퓨터 , :8080 = WAS 포트번호 , /practice2/post
    public boolean POST(){
        System.out.println("PostController.글쓰기");
        return true; // 임의값
    }
    // 매개변수 연결된 중매해주는 수, 호출하는 사람으로부터 받은 값
    //요청자료(클라이언트가 서버에게 요청하는 것) : x , 응답자료(서버가 클라이언트에게 다시 보내는 것) : true/false


    //2. 전체 글 조회 GET http://localhost:8080/practice2/post
    //요청자료 : x , 응답자료 : 임의의 List 타입 , [ {pno:'',ptitle:''} , {pno:'',ptitle:''} ]

    // 대괄호 [ ] 1개 = List 1개 라는 뜻이다제
    // 중괄호 { } 2개 = map 2개 라는 뜻이다제

    // 컬렉션 프레임워크 , [ ] 1개 : List 1개 , { } 1개 : Map 1개 속성 하나 = PUT 하나
    // Map 이란? key 와 value 한 쌍으로 엔트리 갖고 여러 개 엔트리 저장한다. <---> DTO/JSON
    // List< PostDto > vs List< Map< String , Object > >

    @GetMapping
    public List<Map<String,Object>> GET(){
        System.out.println("PostController.전체글조회");
        List<Map < String , Object > > list = new ArrayList<>();
        Map<String,Object> map1 = new HashMap<>();
        map1.put("pno","1"); map1.put("ptitle","제목1");
        Map<String,Object> map2 = new HashMap<>();
        map2.put("pno","2"); map2.put("ptitle","제목2");
        list.add(map1); list.add(map2);
        return list;
    }

    //3. 개별 글 조회 GET http://localhost:8080/practice2/post
    //요청자료 : x , 응답자료 : 임의의 MAP 타입 , {pno:'',ptitle:''}

    public Map<String,Object> VIEW(){
        System.out.println("PostController.개별글조회");
        Map<String,Object> map = new HashMap<>();
        map.put("pno","3"); map.put("ptitle" ,"제목3");
        return map;
    }

    //4. 개글 글 수정 PUT http://localhost:8080/practice2/post
    //요청자료 : x , 응답자료 : true 또는 false

    @PutMapping
    public boolean PUT(){
        System.out.println("PostController.개별글수정");
        return true;
    }
    //5. 개별 글 삭제 DELETE http://localhost:8080/practice2/post

    //요청자료 : x , 응답자료 : 임의의 삭제한 번호 , 3
    @DeleteMapping
    public int DELETE(){
        System.out.println("PostController.개별글삭제");
        return 3;
    }
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
