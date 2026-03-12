package example.day07.practice7.service;

import example.day07.practice7.dto.CourseDto;
import example.day07.practice7.entity.CourseEntity;
import example.day07.practice7.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;
    // 1. 저장
    public boolean 과정정보등록( CourseDto courseDto ){
        // 1] dto --> entity 변환
        CourseEntity courseEntity = courseDto.toEntity();
        // 2] JPA save 이용하여 insert 하기
        CourseEntity saved = courseRepository.save( courseEntity );
        // 3] save 결과에 pk 여부 성공판단
        if( saved.getCourseId() >= 1 ) return true;
        return false;
    }
}
