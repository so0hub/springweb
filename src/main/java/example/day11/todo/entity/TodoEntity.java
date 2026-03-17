package example.day11.todo.entity;


import example.day11.todo.dto.TodoDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // JPA 해당 엔티티를 테이블 매핑
@Table( name = "todo") // 테이블명 정의
@Data@Builder@NoArgsConstructor@AllArgsConstructor // 롬복
public class TodoEntity extends BaseTime {
    // + BaseTime : 엔티티 생성/수정 날짜/시간 상속
    // ++ AppStart 에서 @EnableJpaAuditing 주입한다.
    // 1. 테이블 속성 설계
    @Id @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id; // pk
    @Column( nullable = false , length = 100 ) // + 테이블 속성 옵션
    private String title;   // 제목
    @Column( columnDefinition = "longtext") // + 테이블 속성 옵션
    private String content; // 내용
    @Column( columnDefinition = "boolean default false")
    private Boolean done;   // 실행(체크)여부

    // 카테고리 번호(FK)
    @ManyToOne
    @JoinColumn(name = "cno")
    private CategoryEntity categoryEntity;

    // 3. Entity --> Dto 변환 : R
    public TodoDto toDto(){
        return TodoDto.builder() // new 대신에 사용
                .id( this.id )
                .content( this.content )
                .title( this.title )
                .done( this.done )
                .createDate( this.getCreateDate().toString() )
                .updateDate( this.getUpdateDate().toString() )
                .build();
    }

} // end


