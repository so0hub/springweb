package example.day09.springbootdeveloper.service;

import example.day09.springbootdeveloper.domain.Article;
import example.day09.springbootdeveloper.dto.AddArticleRequest;
import example.day09.springbootdeveloper.dto.UpdateArticleRequest;
import example.day09.springbootdeveloper.repository.BlogRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor // final 이 붙거나 @NotNull 이 붙은 필드의 생성자 추가
@Service // 빈으로 등록
public class BlogService {

    private final BlogRepository blogRepository;

    // 블로그 글 추가 메서드
    public Article save(AddArticleRequest request){
        return blogRepository.save(request.toEntity());
    }


    // 블로그 전체 글 조회 메소드
    public List<Article> findAll(){
        return blogRepository.findAll();

    }

    // 블로그 글 조회 메서드
    public Article findById(long id){
        return blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found : " + id));
    }

    // 블로그 글 삭제 메소드
    public void delete(long id){
        blogRepository.deleteById(id);
    }

    // 블로그 글 수정 메소드
    @Transactional
    public Article update(long id, UpdateArticleRequest request){
        Article article = blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found : " + id));

        article.update(request.getTitle(),request.getContent());
        return article;
    }

}
