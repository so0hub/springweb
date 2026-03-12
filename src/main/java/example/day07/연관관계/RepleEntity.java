package example.day07.연관관계;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.repository.cdi.Eager;

@AllArgsConstructor @NoArgsConstructor @Data @Builder
@Entity @Table( name = "reply" )
public class RepleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rno;
    private String rcontent;
    // ** 단방향 ** FK 만들기
    @ManyToOne( cascade = CascadeType.ALL , fetch = FetchType.LAZY ) // FK 제약조건 설정 뜻
    @JoinColumn(name = "bno") // FK 필드명 설정
    private BoardEntity boardEntity;
}

/*
    - 영속성 이란? 자바 객체 와 데이터베이스 데이터 간 매핑/연결 상태
        - 영속성 해제란 ? 자바 객체 와 데이터베이스 데이터 간 매핑/연결 해제
    - cascade 속성이란? PK와 FK 제약조건 옵션
        CascadeType.ALL : 부모가 삭제/수정/저장 되면 자식도 같이 삭제/수정/저장 반영된다.
        CascadeType.REMOVE : 부모가 삭제 되면 자식도 같이 삭제 반영된다.
        CascadeType.MERGE : 부모가 수정 되면 자식도 같이 수정 반영된다.
        CascadeType.DETACH : 부모가 영속 해제 되면 자식도 같이 영속 해제 반영된다.
        CascadeType.REFRESH : 부모가 재호출(갱신) 되면 자식도 같이 재호출(갱신) 반영된다.
        CascadeType.PERSIST : 부모가 저장 되면 자식도 같이 저장 반영된다.
    - fetch : 부모[pk] 조회시 자식[fk] 관계에서 엔티티 조회여부 선택
        FetchType.EAGER : (기본값) 해당 엔티티 조회시 참조 엔티티 모두 즉시 조회한다.
            - 특징 : 초기 로딩 느리다 , 재사용성 빠르다 , * 불필요한 정보까지 있을 경우 성능 저하
        FetchType.LAZY : 해당 엔티티 조회시 참조 엔티티는 조회하지 않는다. < 참조 엔티티 호출시 조회 >
            - 특징 : 초기 로딩 빠르다 , 재사용성 느리다 , * 필요한 정보까지만 적절하게 사용 * < 지연 로딩 >

    - 단방향 / 양방향 활용
        - 만약에 1번 카테고리에 게시물 등록 한다면
            BoardEntity save Entity = new BoardEntity();
            // saveEntity saveCategoryEntity( 1 ); [x]
            CategoryEntity category = repository.findById(1).get(); [O]
            saveEntity.setCategoryEntity( category ); [O]
            repository.save( saveEntity );

        - 만약에 3번 게시물에 댓글 등록 한다면 , ** fk 필드에 fk 값인 3 대신에 3 갖는 fk엔티티 찾아서 대입하자. **
            ReplyEntity saveEntity = new ReplyEntity();
                BoardEntity board = repository.findById( 3 ).get();
            saveEntity.setBoardEntity( board )
            repository.save ( saveEntity )

        - insert into board( bcontent , cno ) values ( "안녕" , 3 ) 원래 이거였는데 3 대신에 fk 엔티티 찾아서 대입한다는 겨
*/
