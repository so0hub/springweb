package example.day16;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class FileService {

    // 업로드경로1] 로컬 환경
    private String baseDir = System.getProperty("user.dir"); // C:\Users\SKU-102-00\Desktop\springweb
    private String uploadDir = baseDir + "/build/resources/main/static/upload/"; // 상세 경로 추가
    // 업로드경로2] 클라우드 환경 * 추후에 *

    // [1] 업로드
    public String upload(MultipartFile uploadFile ){
        // 1) 만약에 파일이 존재하지 않으면
        if( uploadFile.isEmpty() == true ){ return null; } // 업로드 실패 : 파일없어서
        // 2) 업로드할 파일의 경로 * 서버경로 * ,    개발자(src파일) --배포/실행--> 서버(build파일) <--- 클라이언트(사용자)
        File uploadPath = new File( uploadDir ); // 업로드할 uploadDir 을 file객체내 대입
        // *** 만약에 해당 경로의 폴더가 존재하지 않으면 폴더 생성
        if( uploadPath.exists() == false ){ //  : file객체.exists() : 경로가 존재하면 true
            uploadPath.mkdir(); // file객체.mkdir() : 경로/폴더 생성
        }
        // 3) 업로드 , 실제업로드경로 + 파일명
            // *** 만약에 서로 다른 사람/요청 이 동일한 파일명으로 다른 파일을 업로드하면 고유식별 깨짐 ***
            // 즉] 파일명은 동일하지만 다른 파일일 수 있다. UUID 활용 vs 날짜/시간(밀리초) 넣기 vs 게시물 번호 (PK 번호) 넣기
        String uuid = UUID.randomUUID().toString(); // UUID이란? 중복 없는 난수 문자열 생성 함수(고유성 보장)
            // * UUID _ 파일명 : UUID 와 파일명 사이에 _ 언더바 구분하자 ( 왜? 추후에 분리해야 하니까 )
            // * UUID에는 _ 언더바 절대 없다. 하지만 파일명에는 _ 언더바 존재할 수 있다. ( 파일명 치환 )
        String fileName = uuid+"_"+uploadFile.getOriginalFilename().replaceAll("_","-"); // 업로드할 파일명
        File uploadRealPath = new File( uploadDir + fileName ); // 파일명과 경로 연결해서 최종적인 경로 파일객체 생성
        try {
            uploadFile.transferTo( uploadRealPath ); // 업로드파일을 특정한 경로에 이송/복사 한다. *예외처리 발생*
            return fileName;
        } catch (IOException e) { System.out.println( e ); }
        return null;
    }
} // class end

/*
        System.out.println( uploadFile.isEmpty() ); // 1) 첨부파일 존재 여부 반환 , 존재하면 false
        System.out.println( uploadFile.getOriginalFilename() ); // 2)첨부파일의 파일명
        System.out.println( uploadFile.getContentType() ); // 3) 첨부파일의 확장자
        System.out.println( uploadFile.getSize() ); // 4) 첨부파일의 용량(바이트)

 */