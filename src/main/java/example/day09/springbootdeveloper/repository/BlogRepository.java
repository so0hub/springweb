package example.day09.springbootdeveloper.repository;

import example.day09.springbootdeveloper.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Article , Long> {
}
