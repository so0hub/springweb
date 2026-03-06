//package example.day06.practice6;
//
//import jakarta.persistence.Id;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class MovieService {
//    @Autowired
//    private MovieRepository movieRepository;
//
//    // 영화 등록
//    public boolean 등록( MovieDto movieDto ){
//        // 1] dto --> entity 변환
//        MovieEntity movieEntity = movieDto.toEntity();
//        // 2] JPA save 이용하여 insert 하기
//        MovieEntity saved = movieRepository.save( movieEntity );
//        // 3] save 결과에 pk 여부 성공판단
//        if( saved.getMovieid() >= 1 ) return true;
//        return false;
//    }
//
//    // 영화 전체 조회
//    public List< MovieDto > 영화전체조회() {
//        List<MovieEntity> movieEntityList = movieRepository.findAll(); // entity --> dto 변경
//        List<MovieDto> movieDtoList = new ArrayList<>(); // 여러개 dto 저장할 리스트 선언하기
//        // forEach( 반복변수 -> { 실행문; }
//        movieEntityList.forEach(entity ->{
//            MovieDto movieDto = new MovieDto(); // dto 선언
//            movieDto.setMovieid(entity.getMovieid());
//            movieDto.setTitle(entity.getTitle());
//            movieDto.setDirector(entity.getDirector());
//            movieDto.setReleasedate(entity.getReleasedate());
//            movieDto.setRating(entity.getRating());
//            movieDtoList.add(movieDto); // dto를 리스트에 저장
//        } ); // for END
//        return movieDtoList; // entity가 아닌 dto 반환한다.
//    }
//
//    // 영화 개별 조회
//    public List<MovieDto> 영화개별조회(Integer movieid){
//        Optional<MovieEntity> result = movieRepository.findById(movieid);
//
//        if(result.isPresent()){
//            MovieEntity entity = result.get();
//
//            // Entity --> Dto 변환해서 리턴하기
//            return MovieDto.builder()
//                    .movieid(entity.getMovieid())
//                    .title(entity.getTitle())
//                    .director(entity.getDirector())
//                    .releasedate(entity.getReleasedate())
//                    .rating(entity.getRating())
//                    .build();
//        }else{return null;}
//
//
//    }
//
//    // 특정 영화 수정
//    public
//
//    // 영화 정보 수정
//
//}
