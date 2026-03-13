package example.day09.springbootdeveloper.dto;

import example.day09.springbootdeveloper.domain.Article;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Getter;

@NoArgsConstructor // 기본 생성자 추가
@AllArgsConstructor // 모든 필드 값을 파라미터로 받는 생성자 추가
@Getter
public class AddArticleRequest {

    private String title;
    private String content;

    public Article toEntity(){ // 생성자를 사용해 객체 생성
        return Article.builder()
                .title(title)
                .content(content)
                .build();

    }
}
