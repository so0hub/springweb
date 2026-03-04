package example.day05.mvc;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service @Transactional
public class ExamService {
    @Autowired
    private ExamRepository examRepository;

    // 서비스는 통신을 하는 곳이 아니라 http 관련된 건 서비스에서 안 함. 골뱅이는 http 관여한 것임. 여기선 골뱅이 ㄴㄴ

    // R : 조회 select
    public List< ExamDto > 전체조회(){
        // * select 대신에 JPA함수 사용.   // findAll() : 전체 엔티티/레코드/객체를 반환
        // findAll : 전체조회
        List< ExamEntity > examEntityList = examRepository.findAll();
        // entity --> dto 변경 < 왜 하죠? 안전상. Entity 노출 안 하기 위해 >
        List< ExamDto > examDtoList = new ArrayList<>(); // 1) 여러개 dto 저장할 리스트 선언
        examEntityList.forEach( entity -> {
            // 2) 반복문 for( int  = 0 ; index <= list.size()-1 ; index ++ ) vs forEach( 반복변수 -> { 실행문; } )
            ExamDto examDto = new ExamDto();    // 3) dto 선언
            examDto.setEno( entity.getEno() );  // 4) 반복중인 entity 객체 내 멤버변수를 dto에 저장
            examDto.setEname(entity.getEname() );   // 4) "
            examDtoList.add( examDto ); // 5) dto를 리스트에 저장
        }); // for END
        return  examDtoList; // **entity 가 아닌 dto 반환한다. 왜? 서비스개발자만 entity 다룬다. 왜? 역할과 조작 권한 차이다제.
        }


    // C : 쓰기 insert
    public boolean 저장( ExamDto examDto ){
        // insert 대신에 JPA 함수 사용
        // .save( 엔티티 ) : 해당 엔티티를 insert 한다.
        // 1] 저장할 DTO --> ENTITY 변환
        ExamEntity examEntity = new ExamEntity();
        examEntity.setEname( examDto.getEname() );
        // 2] .save 이용한 insert 하기
        ExamEntity savedEntity = examRepository.save( examEntity );
        // 3] 처리한 entity의 pk(primary key) 여부
        if( savedEntity.getEno() >= 1) return true; // pk
        return false;

    }

    // D : 삭제 delete
    public boolean 삭제( int eno ){
        // delete 대신에 JPA 함수 사용
        // .deleteById( 삭제할 pk 번호 ); 해당하는 pk가 존재하면 삭제.
        examRepository.deleteById( eno );
        return true;
    }

    // U : 수정 update
    @Transactional()
    public boolean 수정( ExamDto examDto ){
        // update 대신에 JPA 영속성( 계속되는 성질/능력 ) 사용한다.
        // 데이터베이스 와 자바객체 연결되는 상태를 계속적으로 유지
        // 즉] 자바객체가 수정되면 데이터베이스도 자동 수정
        // 1] 수정할 엔티티 찾기 , PK
        // findById( 수정할 pk 번호 )
        Optional< ExamEntity > optional
                =examRepository.findById( examDto.getEno() );
        // 2] 만약에 엔티티가 존재하면 , isPresent() : 조회 결과가 있으면 true , 없으면 false 반환 함수
        if( optional.isPresent() ){
            ExamEntity examEntity = optional.get(); // 존재한 엔티티 꺼내기
            // ****************** 영속성 이용한 수정 *********************
            examEntity.setEname( examDto.getEname() ); // 입력받은(수정할) 값을 엔티티에 setter 이용하여 수정한다.
            return true;
        }
        return false;
    }

    /*
    1] <> : 제네릭 타입, 객체 생성할 때 타입 지정
    2] Optional< > : 객체 내 null 값 제어 기능/함수 제공하는 클래스 , null에 따른 안전한 객체 사용
        1. .isPresent() : 만약에 null 이면 false 반환 , 아니면 true 반환
        2. .get() : 객체 반환
        3. .orElse( null일 때 값 )
        4. .orElseThrow( 예외값 )
        사용처 : JPA 에서 findById 반환 타입 그 외 몇몇 라이브러리 사용된다.
        사용법 :
            방법1] Optional< 엔티티 > 변수명 = repository.findById()
            방법2] 엔티티 변수명 = repository.findById( ).orElse( )
     3] JPA CRUD 기본 제공
        1. .findAll( )                  : 모든 레코드/객체/엔티티 조회(select) , 반환타입 List<엔티티명>
        2. .findById( 조회할pk번호 )     : 특정 pk번호의 엔티티 반환 , 반환타입 : Optional< 엔티티명 >
        3. .save( 저장할엔티티 )          : 특정 엔티티를 저장(insert) , 반환타입 : 엔티티
        4. .deleteById( 삭제할pk번호 )   : 특정 pk번호의 엔티티 삭제(delete) , 반환타입 : void
        5. 수정함수는 존재하지 않는다. < 영속성 특징 >
            - 영속성 갖는 시점 : save , findAll , findById 등등 반환된 엔티티가 영속된( DB와 연결된 ) 엔티티
            * 영속성이란 ? 데이터베이스 와 자바객체 연결하는 관계
            - 영속된 엔티티를 .setter 이용하여 객체 수정하면 자동으로 데이터베이스도 반영된다.
            - @Transactional 갖는 클래스/메소드는 여러 SQL들을 하나의 묶음으로 한번에 처리한다.
                - 즉] 트랜잭션이란? 여러 SQL들을 묶어서 하나라도 실패하면 모두 실패( ROLLBACK ) 모두 성공이면 최종 성공( COMMIT )
                - 예1] 이체 기능은 [1] 입금 [2] 출금  2개 이상의 기능을 묶음 기능
                    - 입금 과 출금 중에 하나라도 문제가 발생하면 전체 (이체)취소
                - 영속된 객체를 .setter 이용하여 여러개 수정함으로써 여러개 수정(update)들을 하나로 처리한다.
                - 즉] 수정하는 메소드에는 @Transactional 필수이다.
    */
} // class END
