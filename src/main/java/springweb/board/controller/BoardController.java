package springweb.board.controller;


import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springweb.board.dto.BoardDto;
import springweb.board.service.BoardService;
import springweb.member.service.JWTService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/board")
public class BoardController {
    private final BoardService boardService;
    private final JWTService jwtService;

    // [1] 회원제 글등록 + 세션 정보
    @PostMapping("/write")
    // http://localhost:8080/api/board/write
    //  { "btitle" : "테스트제목" , "bcontent" : "테스트내용"  }
    public ResponseEntity<?> write(@RequestBody BoardDto boardDto , HttpSession session ){ // 회원제니까 세션 사용!!!!
        // 1) 세션내 로그인정보 확인
        Object object = session.getAttribute("loginMid");
        if( object == null ){ return ResponseEntity.ok( false ); } // 만약에 비로그인이면 글쓰기 실패
        // 2) 로그인 중이면
        String loginMid = (String)object;
        // 3) 서비스에게 입력받은 값과 세션에 저장된 값 전달한다.
        boolean result = boardService.write( boardDto , loginMid );
        return  ResponseEntity.ok( result );
    }


    // [1-2] 회원제 글등록 + 토큰 정보
    @PostMapping("/write2")
    // http://localhost:8080/api/board/write2
    // { "btitle" : "테스트제목" , "bcontent" : "테스트내용"  }
    public ResponseEntity<?> write2( @RequestBody BoardDto boardDto ,
                                     @RequestHeader("Authorization") String token ){
        // 1) 매개변수로 jwt토큰 받는다.
        // 2) 만약에 토큰이 없거나 Bearer 시작하지 않으면 , 문자열.startsWith( "시작문자" ) : 문자열내 시작문자가 존재하면 true
        if( token == null || !token.startsWith("Bearer") ) {
            return ResponseEntity.ok( false ); // 비로그인 이라서 글쓰기 실패
        }

        // * 토큰만 추출
        token=token.replace("Bearer ","");

        // 3) 토큰에서 클레임(값) 꺼내기
        String loginMid = jwtService.getClaim( token );
        if( loginMid == null ){ return ResponseEntity.ok(false); }
        // 4) 서비스에게 입력받은 값과 세션에 저장된 값 전달한다.
        boolean result = boardService.write( boardDto , loginMid );
        return  ResponseEntity.ok( result );
    }

    // [1-3] 회원제 글등록 + 토큰 정보 + 첨부파일( content-Type : multipart/form-data 변경 )
    @PostMapping("/write3")
    // http://localhost:8080/api/board/write3

    public ResponseEntity<?> write3( BoardDto boardDto , @RequestHeader("Authorization") String token ){
        // 달라진점1] @RequestBody 사용하지 않는다. 왜? 첨부파일 매핑하기 위해
        // 달라진점2] dto에 MultipartFile 인터페이스 포함한다. private MultipartFile uploadFile; // 업로드용도
        if( token == null || !token.startsWith("Bearer") ) {
            return ResponseEntity.ok( false );
        }
        token = token.replace("Bearer " , "");
        String loginMid = jwtService.getClaim( token );
        if( loginMid == null ){ return ResponseEntity.ok(false); }
        boolean result = boardService.write( boardDto , loginMid );
        return  ResponseEntity.ok( result );
    }
}
