package example.day06.practice6;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor @NoArgsConstructor @Builder @Data // 롬복
@Entity @Table(name = "movie")
public class MovieEntity extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer movieid; // 영화번호

    @Column( name = "영화제목" , nullable = false , length = 100 )
    private String title; // 영화제목

    @Column( name = "감독" , nullable = false , length = 100 )
    private String director; // 감독

    @Column( name = "개봉일" , nullable = false , length = 100 )
    private String releasedate; // 개봉일

    @Column( name = "평점" , nullable = false , length = 20 )
    private Integer rating; // 평점

    // ** ENTITY --> DTO 변환함수 **
    public MovieDto toDto(){
        return MovieDto.builder() // 빌더 시작
                .movieid(this.movieid)
                .title(this.title)
                .director(this.director)
                .releasedate(this.releasedate)
                .rating(this.rating)
                .build(); // 빌더 끝
    }
} // class END
