package example.day05.practice5;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table( name = "book" )
@Data @AllArgsConstructor @NoArgsConstructor
public class CRUDEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bno;

    @Column( name="bid" , length = 255 , nullable = true ) // 테이블 필드 속성
    private String bid;
    @Column( name="bname" , length = 255 , nullable = true )
    private String bname;
    @Column( name="bauthor" , length = 255 , nullable = true )
    private String bauthor;
    @Column( name="bpublisher" , length = 255 , nullable = true )
    private String bpublisher;


}

