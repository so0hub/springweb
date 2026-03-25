package example.day16;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/file")
public class FileController {
    private final FileService fileService;

    // [1] 서버에 파일 업로드
    // method : post
    // url : http://localhost:8080/api/file
    // Headers : Content-Type : multipart/form-data
    // Body : [text] -> [form]  , uploadFile [ file ] 컴퓨터파일선택
    @PostMapping("")
    public ResponseEntity<?> upload(MultipartFile uploadFile ){
        System.out.println("FileController.upload"); // soutm
        System.out.println("uploadFile = " + uploadFile); // soutp
        return ResponseEntity.ok( fileService.upload( uploadFile ) );
    }

    // [2] 서버에 파일 다운로드

    // [3] 서버에 파일 삭제

}
/*
    1.업로드 : 클라이언트가 서버에게 데이터(파일)을 전송 하는 행위
    2.다운로드 : 서버가 클라이언트에게 데이터(파일)을 전송 하는 행위
    3.스트림 : 데이터가 이동하는 흐름 , 스트림API / 파일처리 / 네트워크 등등
    4.버퍼 : 데이터가 이동하는 흐름간의 처리속도를 일정하게 하기위한 임시 메모리 * 흐름 하는 순간에도 누군가의 기억! *
    5.자바입출력 클래스
        1) FileInputStream
        2) ServletOutputStream 등등
    [ 스프링 파일 업로드 구현 ] * 내장 업로드객체 지원한다.
        1. MultipartFile 클래스 : 첨부파일(바이트) 매핑하는 인터페이스
        2. 사용법
            첨부파일1개 : MultipartFile 변수명
            첨부파일N개 : List< MultipartFile > 변수명
        3. content-Type : multipart/form-data
*/

/*
    (1) 쿼리스트링 방식 ,  URL ? 변수명 = 값
    (2) 본문 방식 , URL , { "변수명" : 값 } , content-type : application/json
    (3) 대용량(바이트) 방식 , URL , form , content-type : multipart/form-data
 */