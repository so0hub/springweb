package example.day06.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data // 롬복
public class GoodsDto {
    private Integer gno; // 제품번호
    private String gname; // 제품명
    private String gdesc; // 제품설명
    private Integer gprice; // 제품가격
    // + baseTime
    private String createDate;
    private String updateDate;

    // ** DTO --> ENTITY 변환함수 **
    public GoodsEntity toEntity(){
        // 빌더패턴이란? new 생성자가 아닌 함수로 객체 생성
        // this이란? 해당 메소드/함수 실행한 객체 // 해도 되고 안 해도 됨
        return GoodsEntity.builder() // 빌더 시작
                .gno( this.gno )
                .gname( this.gname )
                .gdesc( this.gdesc )
                .gprice( this.gprice )
                .build(); // 빌더 끝
    }

}
