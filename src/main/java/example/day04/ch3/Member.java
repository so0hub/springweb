package example.day04.ch3;

import jakarta.persistence.*;
import lombok.*;


@NoArgsConstructor( access = AccessLevel.PROTECTED) // 빈생성자 이면서 protected접근제한 (자동생성)
@AllArgsConstructor // 전체매개변수를 갖는 (자동생성) 생성자
@Getter // getter (자동생성) 메소드
// @Setter
@Entity // 데이터베이스의 테이블 레코드 와 매핑(연결) 기술 : ORM(자바객체<-->DB레코드)
public class Member {
    @Id // PK
    @GeneratedValue( strategy = GenerationType.IDENTITY ) // auto_increment
    @Column( name = "id" , updatable = false ) // 필드/속성명 설정, 수정 불가능
    private Long id;

    @Column(name = "name" , nullable = false ) // 필드/속성명 설정 , not null
    private String name;
}