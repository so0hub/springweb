package springweb.board.entity;

import jakarta.persistence.*;
import lombok.*;
import springweb.board.dto.BoardDto;
import springweb.member.entity.BaseTime;
import springweb.member.entity.MemberEntity;

@Entity
@Table(name="board")
@NoArgsConstructor @AllArgsConstructor @Data
@Builder
public class BoardEntity extends BaseTime {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long bno; // 게시물번호

    @Column( nullable = false , length = 255 )
    private String btitle; // 게시물제목

    @Column( nullable = false , columnDefinition = "longtext" )
    private String bcontent; // 게시물내용

    @Column( nullable = true , columnDefinition = "longtext" ) // 주로 첨부파일은 파일 자체를 저장하는 게 아니라 !!! 파일의 위치(서버내경로) 저장.
    private String bfile; // 게시물첨부파일 , 만약에 게시물당 첨부파일 여러개이면 엔티티 분리

    // + 단방향 : 한 명의 회원이 여러개 게시물 작성한다. 1:N (일대다 관계)
    @ManyToOne
    @JoinColumn(name="mno") @ToString.Exclude
    private MemberEntity memberEntity;

    // + toDto
    public BoardDto toDto(){
        return BoardDto.builder()
                .bno(bno)
                .btitle(btitle)
                .bcontent(bcontent)
                .bfile(bfile)
                .mno(memberEntity.getMno()) // 작성자FK의 회원번호
                .mname(memberEntity.getMname()) // 작성자FK의 닉네임
                .build();
    }
}
