package example.day09.springbootdeveloper.domain;

import example.day08.BaseTime;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@EntityListeners(AuditingEntityListener.class)
@Entity // 엔티티로 지정
@Getter
@NoArgsConstructor( access = AccessLevel.PROTECTED )
public class Article {

    @Id // ide 필드를 기본키로 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본키를 자동으로 1씩 증가
    @Column( name = "id" , updatable = false )
    private Long id;

    @Column( name = "title" , nullable = false ) // 'title' 이라는 not null 컬럼과 매핑
    private String title;

    @Column( name = "content" , nullable = false ) // 'title' 이라는 not null 컬럼과 매핑
    private String content;

    @Builder // 빌더 패턴으로 객체 생성
    public Article( String title , String content ){
        this.title = title;
        this.content = content;
    }

    // 블로그 글 수정 메소드
    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }

    @CreatedDate // 엔티티가 생성될 때 생성 시간 저장
    @Column(name="created_at")
    private LocalDateTime createdAt;

    @LastModifiedDate // 엔티티가 수정될 때 수정시간 저장
    @Column(name="updated_at")
    private LocalDateTime updateAt;
}
