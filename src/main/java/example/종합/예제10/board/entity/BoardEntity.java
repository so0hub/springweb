package example.종합.예제10.board.entity;

import example.종합.예제10.board.dto.BoardDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor @Data @Builder // 롬복
@Entity
@Table( name = "board")
public class BoardEntity extends BaseTime {
    @Id // PK
    @GeneratedValue( strategy = GenerationType.IDENTITY ) // auto_increment
    private Integer bno;

    @Column( nullable = false , length = 255 ) // not null
    private String btitle;

    @Column( columnDefinition = "longtext not null") // 자바에는 long text가 없어서 이렇게 직접 sql 설정해야함!
    private String bcontent;

    @Column( length = 30 , nullable = false ) // not null
    private String bwriter;
    // + 생성/수정 날짜/시간은 BaseTime으로 상속받기


    // + entity --> dto 변환 함수 *
    public BoardDto toDto(){
        return BoardDto.builder()
                .bno(bno)
                .btitle(btitle)
                .bcontent(bcontent)
                .bwriter(bwriter)
                .createDate(getCreateDate().toString())
                .updateDate(getUpdateDate().toString())
                .build();
    }

}
