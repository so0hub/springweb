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
    public boolean 수강정보등록(EnrollDto enrollDto){
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
    public List< EnrollDto > 수강정보조회(){
        List< EnrollEntity > enrollEntityList = enrollRepository.findAll(); // entity --> dto 변경
        List< EnrollDto > enrollDtoList = new ArrayList<>(); // 여러개 dto 저장할 리스트 선언
        // forEach( 반복변수 -> { 실행문 }
        enrollEntityList.forEach(entity  -> {
            EnrollDto enrollDto = new EnrollDto(); // dto 선언
            enrollDto.setEnrollId(entity.getEnrollId());
            enrollDto.setStatus(entity.getStatus());


            enrollDto.setCreateDate(entity.getCreateDate()); // 까먹지마르르르렴...
            enrollDto.setUpdateDate(entity.getUpdateDate());


           // enrollDto.setStudentName(entity.getStudentName());
           // enrollDto.setCourseName(entity.getCourseName());

            // => EnrollEntity 안에 학생이름,과정이름이 직접 들어있는가 ? 아니오.
            // studentEntity CourseEntity 라는 다른 엔티티에 들어있고 Enroll은 그걸 참조하는 형식임.

            // 그래서 이렇게 수정해야 함.
            // EnrollEntity 안에 있는 연관된 엔티티를 먼저 꺼내고 그 안에서 이름을 가져와야 한다.

            // 연관된 StudentEntity 를 거쳐서 학생이름 가져오기
            if(entity.getStudentEntity() != null){
                enrollDto.setStudentName(entity.getStudentEntity().getStudentName());
                enrollDto.setStudentId(entity.getStudentEntity().getStudentId());
            }

            // 연관된 CourseEntity 를 거쳐서 과정이름 가져오기
            if(entity.getCourseEntity() != null){
                enrollDto.setCourseName(entity.getCourseEntity().getCourseName());
                enrollDto.setCourseId(entity.getCourseEntity().getCourseId());
            }

            enrollDtoList.add(enrollDto); // dto를 리스트에 저장
        } ); // for END
        return enrollDtoList; // entity 가 아닌 dto 반환한다.
    }

}
