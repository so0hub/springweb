package example.종합.예제10.board.dto;

import example.종합.예제10.board.entity.BoardEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor @Data @Builder
public class BoardDto {
    private Integer bno;
    private String btitle;
    private String bcontent;
    private String bwriter;
    private String createDate;
    private String updateDate;



    // + dto --> entity 변환함수 : 주로 저장 *
    public BoardEntity toEntity(){
        return BoardEntity.builder()
                // bno, createDate , updateDate // 자동부여라서 생략 가능
                .btitle( btitle )
                .bcontent( bcontent )
                .bwriter( bwriter )
                .build();
    }
}
