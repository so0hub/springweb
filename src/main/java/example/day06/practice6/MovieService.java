package example.day06.practice6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    // 영화 등록
    // 영화 전체 조회
    // 영화 개별 조회
    // 특정 영화 수정
    // 영화 정보 수정
}
