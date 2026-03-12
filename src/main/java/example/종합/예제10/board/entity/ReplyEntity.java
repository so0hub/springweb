package example.종합.예제10.board.entity;
import example.종합.예제10.board.dto.ReplyDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder // 롬복
@Entity
@Table( name = "reply")
public class ReplyEntity extends BaseTime{
    @Id // pk
    @GeneratedValue(strategy = GenerationType.IDENTITY ) // auto_increment
    private Integer rno;

    @Column( columnDefinition = "longtext not null")
    private String rcontent;

    @Column( length = 30 , nullable = false )
    private String rwriter;

    // + entity --> dto 변환 함수 *
    public ReplyDto rtoDto(){
        return ReplyDto.builder()
                .rno(rno)
                .rcontent(rcontent)
                .rwriter(rwriter)
                .createDate(getCreateDate().toString())
                .updateDate(getUpdateDate().toString())
                .build();
    }

    // 단방향 연결
    // 하위 엔티티가 상위 엔티티 참조관계
    @ManyToOne
    @JoinColumn( name ="bno") // FK 필드명(+PK필드명과 동일 권장)
    private BoardEntity boardEntity;
}
