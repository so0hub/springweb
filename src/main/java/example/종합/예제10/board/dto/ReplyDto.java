package example.종합.예제10.board.dto;

import example.종합.예제10.board.entity.ReplyEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ReplyDto {
    private Integer rno;
    private String rcontent;
    private String rwriter;
    private String createDate;
    private String updateDate;

    // + dto --> entity 변환함수 : 주로 저장 *
    // + dto --> entity 변환함수 : 주로 저장 *
    public ReplyEntity rtoEntity(){
        return ReplyEntity.builder()
                // bno, createDate , updateDate // 자동부여라서 생략 가능
                .rcontent( rcontent )
                .rwriter( rwriter )
                .build();
    }
    }

