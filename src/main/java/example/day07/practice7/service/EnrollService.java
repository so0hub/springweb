package example.day07.practice7.service;

import example.day07.practice7.dto.EnrollDto;
import example.day07.practice7.entity.CourseEntity;
import example.day07.practice7.entity.EnrollEntity;
import example.day07.practice7.entity.StudentEntity;
import example.day07.practice7.repository.CourseRepository;
import example.day07.practice7.repository.EnrollRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import example.day07.practice7.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class EnrollService {
    @Autowired
    private EnrollRepository enrollRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRepository courseRepository;

    @Transactional // 연관 객체를 다룰 때에는 트랜잭션 붙이기.
    public boolean 수강정보등록(EnrollDto enrollDto) {
        // 1. DTO에 담긴 ID로 실제 학생과 과정 엔티티를 찾는다.
        StudentEntity student = studentRepository.findById(enrollDto.getStudentId())
                .orElseThrow(() -> new RuntimeException("존재하지 않는 학생입니다."));
        CourseEntity course = courseRepository.findById(enrollDto.getCourseId())
                .orElseThrow(() -> new RuntimeException("존재하지 않는 과정입니다."));

        // 2. 엔티티 생성 및 연관 관계 설정
        EnrollEntity enrollEntity = EnrollEntity.builder()
                .status(enrollDto.getStatus())
                .studentEntity(student) // 찾은 학생 넣어주기
                .courseEntity(course)   // 찾은 과정 넣어주기
                .build();

        // 3. 저장
        EnrollEntity saved = enrollRepository.save(enrollEntity);
        return saved.getEnrollId() >= 1;
    }

    // 2. 수강 정보 조회
    public EnrollDto 수강정보조회(Integer enrollId) { // 매개변수로 ID를 받습니다. 리턴은 단일 DTO!

        // 1] JPA의 findById를 사용하여 엔티티 하나를 찾습니다.
        // 만약 번호가 없으면 예외를 던집니다. (orElseThrow)
        EnrollEntity entity = enrollRepository.findById(enrollId)
                .orElseThrow(() -> new IllegalArgumentException("해당 수강 번호가 존재하지 않습니다."));

        // 2] 찾은 엔티티를 DTO로 변환합니다. (반복문 필요 없음!)
        EnrollDto enrollDto = new EnrollDto();
        enrollDto.setEnrollId(entity.getEnrollId());
        enrollDto.setStatus(entity.getStatus());

        // 날짜 데이터 세팅
        enrollDto.setCreateDate(entity.getCreateDate());
        enrollDto.setUpdateDate(entity.getUpdateDate());

        // 학생 정보 연관 관계 처리
        if (entity.getStudentEntity() != null) {
            enrollDto.setStudentName(entity.getStudentEntity().getStudentName());
            enrollDto.setStudentId(entity.getStudentEntity().getStudentId());
        }

        // 과정 정보 연관 관계 처리
        if (entity.getCourseEntity() != null) {
            enrollDto.setCourseName(entity.getCourseEntity().getCourseName());
            enrollDto.setCourseId(entity.getCourseEntity().getCourseId());
        }

        // 3] 단일 DTO 반환
        return enrollDto;
    }
}