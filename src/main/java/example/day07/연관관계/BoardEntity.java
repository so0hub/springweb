package example.day07.연관관계;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor @AllArgsConstructor @Data @Builder
@Entity @Table(name = "board")
public class BoardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bno;
    private String bcontent;
    // ** 단방향 ** FK 만들기 **
    @ManyToOne // 다수가 하나에게 , 1:M , 하나의 카테고리에 여러게시물 참조
    @JoinColumn( name = "cno") // 관례적으로 fk 필드명도 pk 필드명과 동일하게 함
    private CategoryEntity categoryEntity;

    // ** 양방향 **
    @OneToMany( mappedBy = "boardEntity" )
    @ToString.Exclude @Builder.Default
    private List<RepleEntity> repleEntityList
            = new ArrayList<>();
}
//create table board (
//        bno integer not null auto_increment,
//        bcontent varchar(255),
//        primary key (bno)
//         ) engine=InnoDB