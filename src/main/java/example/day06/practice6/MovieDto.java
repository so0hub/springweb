package example.day06.practice6;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor @Builder @Data // 롬복
public class MovieDto {
    private Integer movieid; // 영화번호
    private String title; // 영화제목
    private String director; // 감독
    private String releasedate; // 개봉일
    private Integer rating; // 평점

    // basetime
    private String createDate;
    private String updateDate;

    // ** DTO --> ENTITY 변환함수 **
    public MovieEntity toEntity() { // 빌더 시작
        return MovieEntity.builder() // 빌더 시작
                .movieid(this.movieid)
                .title(this.title)
                .director(this.director)
                .releasedate(this.releasedate)
                .rating(this.rating)
                .build(); // 빌더 끝
    }
}
