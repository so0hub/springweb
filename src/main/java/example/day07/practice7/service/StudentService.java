package example.day07.practice7.service;

import example.day07.practice7.dto.StudentDto;
import example.day07.practice7.entity.StudentEntity;
import example.day07.practice7.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    // 1. 저장
    public boolean 학생정보등록(StudentDto studentDto ){
        // 1] dto --> entity 변환
        StudentEntity studentEntity = studentDto.stoEntity();
        // 2] JPA save 이용하여 insert 하기
        StudentEntity saved = studentRepository.save( studentEntity );
        // 3] save 결과에 pk 여부 성공판단
        if( saved.getStudentId() >= 1 ) return true;
        return false;
    }
}
