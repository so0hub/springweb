package example.day05.practice5;


import example.day05.mvc.ExamDto;
import example.day05.mvc.ExamEntity;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service @Transactional
public class CRUDService {
    @Autowired
    private CRUDRepository crudRepository;

// 도서 전체 조회
    public List< CRUDDto > 전체조회() {
        List<CRUDEntity> crudEntityList = crudRepository.findAll(); // entity --> dto 변경
        List<CRUDDto> crudDtoList = new ArrayList<>(); // 여러개 dto 저장할 리스트 선언
        // forEach( 반복변수 -> { 실행문; }
        crudEntityList.forEach(entity -> {
            CRUDDto crudDto = new CRUDDto(); // dto 선언
            crudDto.setBno(entity.getBno());
            crudDto.setBid(entity.getBid()); // 반복 중인 entity 객체 내 멤버변수를 dto에 저장
            crudDto.setBname(entity.getBname());
            crudDto.setBauthor(entity.getBauthor());
            crudDto.setBpublisher(entity.getBpublisher());
            crudDtoList.add(crudDto); // dto를 리스트에 저장
        }); // for END
        return crudDtoList; // entity가 아닌 dto 반환한다.
    }
// 도서 등록
    public boolean 등록( CRUDDto crudDto ){
        // 저장할 DTO --> ENTITY 변환
        CRUDEntity crudEntity = new CRUDEntity();
        crudEntity.setBname(crudDto.getBname());
        crudEntity.setBauthor(crudDto.getBauthor());
        crudEntity.setBpublisher(crudDto.getBpublisher());

        // .save 이용한 insert 하기
        CRUDEntity savedEntity = crudRepository.save( crudEntity );

        // 처리한 entity의 pk(primary key) 여부
        if( savedEntity.getBno() >= 1 )return true; // pk
        return false;

    }

// 특정 도서 삭제 delete
public boolean 삭제( int bno ){
    // delete 대신에 JPA 함수 사용
    // .deleteById( 삭제할 pk 번호 ); 해당하는 pk가 존재하면 삭제.
    crudRepository.deleteById( bno );
    return true;
}
// 특정 도서 수정 update
@Transactional()
public boolean 수정( CRUDDto crudDto ) {
    // 1] 수정할 엔티티 찾기 , PK
    // findById( 수정할 pk 번호 )
        Optional<CRUDEntity> optional
            =crudRepository.findById( crudDto.getBno() );
    // 2] 만약에 엔티티가 존재하면 , isPresent() : 조회 결과가 있으면 true , 없으면 false 반환 함수
    if( optional.isPresent() ){
        CRUDEntity crudEntity = optional.get(); // 존재한 엔티티 꺼내기
        // ****************** 영속성 이용한 수정 *********************
        crudEntity.setBname( crudDto.getBname() ); // 입력받은(수정할) 값을 엔티티에 setter 이용하여 수정한다.
        return true;
    }
    return false;
}


 }
