package springweb.board.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import springweb.board.entity.BoardEntity;

@NoArgsConstructor @AllArgsConstructor @Data @Builder
public class BoardDto {
    // ============== 등록용 =================
    private Long bno; // 게시물번호
    private String btitle; // 게시물제목
    private String bcontent; // 게시물내용
    private String bfile; // 게시물첨부파일 , 만약에 게시물당 첨부파일 여러개이면 엔티티 분리


    // ============== 조회용 =================
    // + Dto 에는 엔티티 정보를 포함하지 않는다. !!!!!!!!!!!! 필요한 정보만 내맘대로 멤버변수 구성한다.
    private Long mno; // 회원번호
    private String mname; // 회원닉네임
    // BaseTime 멤버변수
    private String createDate;
    private String updateDate;

    // + toEntity
    public BoardEntity toEntity(){
        return BoardEntity.builder()
                // .bno(bno) : auto니까 생략
                .btitle(btitle)
                .bcontent(bcontent)
                .bfile(bfile)
                // .memberEntity() fk는 서비스에서 대입.
                .build();
    }
}

