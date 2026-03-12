package example.day06.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor @Builder @Data // 롬복
@Entity @Table(name = "goods") // + 영속성
public class GoodsEntity extends BaseTime {

    @Id // JPA는 엔티티 내 1개 이상의 primary key 필수로 한다.

    @GeneratedValue( strategy = GenerationType.IDENTITY ) // auto_increment

    private Integer gno; // 제품번호

    @Column( name = "제품명" , nullable = false , length = 100 ) // ( unique = true , insertable = true , updatable = true )
    private String gname; // 제품명

    @Column( columnDefinition = "varchar(100) default '제품설명' not null" )
    private String gdesc; // 제품설명

    // @Column // 생략가능시 : 자바의 타입 --> SQL 타입 , 자바의 변수명 --> sQL 필드명
    private Integer gprice; // 제품가격

    // ** ENTITY --> DTO 변환함수 **
    public GoodsDto toDto(){
        return GoodsDto.builder() // 빌더 시작
                .gno( gno )
                .gname( gname )
                .gdesc( gdesc )
                .gprice( gprice )
                .createDate( getCreateDate().toString() ) // .toString 말고 .format() 해도 됨
                .updateDate( getUpdateDate().toString() )
                .build(); // 빌더 끝
    }

} // class END
/*
    @Id : primary key
    @GeneratedValue( strategy = GenerationType.IDENTITY ) // auto_increment
    @Column( ) , 생략시 기본값 적용
        name = "필드명"              ,       기본값은 자바필드명
        nullable = false            ,       기본값은 true , not null을 뜻함
        length = 길이                ,       기본값은 255 , varchar(길이)
        unique = true               ,       기본값은 false , 중복여부
        insertable = true           ,       기본값은 true , insert 할 때 적용여부
        insertable = true           ,       기본값은 true , update 할 때 적용여부
        columnDefinition = "SQL"    ,       JPA가 아닌 네이티브(실제SQL) 쿼리 작성
        레코드 생성( 회원가입/등록일/주문일/작성일 등등 )날짜 / 수정날짜
*/