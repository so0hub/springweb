package springweb.member.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springweb.member.dto.MemberDto;
import springweb.member.service.JWTService;
import springweb.member.service.MemberService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/member2")
public class MemberController2 {
    private final MemberService memberService;
    private final JWTService jwtService;
    // [1] 회원가입 == 세션방식과 동일하므로 생략

    // [2] 로그인 = 세션방식 ---> 토큰방식 변경
    @PostMapping("")
    // http://localhost:8080/api/member2/login
    //
    public ResponseEntity<?> login(@RequestBody MemberDto loginDto){
        boolean result = memberService.login(loginDto);
        // 1] 만약에 로그인 성공이면 토큰 부여
        if(result){
            String token = jwtService.createToken(loginDto.getMid()); // 2] 로그인 성공한 정보(아이디)를 토큰에 저장
            return ResponseEntity.ok()
                    // 3] ** 토큰(jwt)은 주로 세션과 다르게 서버에 저장하지 않고 클라이언트에 저장한다.
                    .header("Authorization","Bearer " + token ) //HTTP 통신의 부가정보 담는 구역 ( 주로 인증정보 포함 )
                    // 클라이언트에게 헤더에 발급받은 jwt 토큰 반환한다. Bearer token ( Bearer 뒤에 띄어쓰기 하는 것 주의 !!!!!!!!!!! )
                    .body(true); // 성공 의미
        }
        // 3] 아니면 실패
        return ResponseEntity.ok(false);
    }
    // [3] 로그아웃 = 세션방식 ---> 토큰방식 변경
    // 서버가 token 저장하고 있지 않기 때문에 통신이 필요없다.
    // 즉] 클라이언트 측에서 token 제거하면 된다.

    // [4] 마이페이지 = 세션방식 ---> 토큰방식 변경
    @GetMapping("/my/info")
    public ResponseEntity<?> myInfo(@RequestHeader("Authorization") String token ){
        // @RequestHeader : HTTP 요청의 header 정보 매핑
        // 1] @RequestHeader("Authorization") String token 매개변수로 받는다.
        // 2] 만약에 헤더가 없거나 토큰이 없으면 비로그인
        if (token == null || !token.startsWith("Bearer") ){
            return ResponseEntity.ok(false);
        }
        // 3] 토큰 추출 , 문자열.replace("기존문자","새로운문자")
        token = token.replace("Bearer " , ""); // Bearer 없애기
        // Bearer eyjhbGci0iJIUz ---> eyjhbGci0iJIUz ( 이렇게 된다는 뜻 )

        // 4] 토큰에서 값(클레임) 추출
        String mid = jwtService.getClaim(token);
        if(mid == null) return ResponseEntity.ok(false);
        // 5] 토큰에서 꺼낸 값(mid)으로 회원정보 요청하기
        return ResponseEntity.ok(memberService.myinfo(mid));
        }
    }
