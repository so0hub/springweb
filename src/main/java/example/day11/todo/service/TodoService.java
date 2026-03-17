package example.day11.todo.service;


import example.day11.todo.dto.TodoDto;
import example.day11.todo.entity.TodoEntity;
import example.day11.todo.repository.TodoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor // final 멤버변수 생성자 제공
@Transactional // 트랜잭션
public class TodoService {
    private final TodoRepository todoRepository;

    // 1. 전체조회
    public List<TodoDto> findAll(){
        // 1] 모든 엔티티 조회한다.
        List<TodoEntity> entityList = todoRepository.findAll();
        // 2] 모든 엔티티 -> 모든 dto 변환한다.
        //// 방법 1]
        //List<TodoDto> List1 = new ArrayList<>();
        //        for( int i = 0 ; i< entityList.size() ; i++ ){
        //TodoEntity entity = entityList.get(i);
        //            list1.add( entity.toDto() );
        //        }
        //
        //// 방법2]
        //List<TodoDto> list2 = new ArrayList<>();
        //        entityList.stream().forEach( entity -> { list2.add(entity.toDto() ); }); // forEach 함수는 반환이 없다.
        //// 방법3]
        //List<TodoDto> list3 = entityList.stream() // 스트림(데이터들 흐름) 시작
        //        .map( entity -> entity.toDto() ) // 중간연산 , 람다식 ( 함수 정의 )
        //        .collect(Collectors.toList() ); // 최종연산
        // 방법4]
        List<TodoDto> list4 = entityList
                .stream()
                .map( TodoEntity :: toDto ) // 중간연산 , 람다식 대신에 메소드레퍼런스 API( 미리 정의된 메소드 )
                // 클래스명 :: 메소드명
                .collect( Collectors.toList() );

        return  list4;
    }

    // 2. 개별조회
    public TodoDto findById( int id ){
//        // 방법1]
//        Optional<TodoEntity> optional = todoRepository.findById(id);
//        if( optional.isPresent() ){
//            TodoDto todoDto = optional.get().toDto();
//        }
        // 방법2]
        TodoDto todoDto = todoRepository.findById(id)
                // 스트림(데이터들) 사용하지 않고 Optional 에서 map 메소드 지원
                // .stream() // 스트림(데이터들의흐름)
                .map( TodoEntity :: toDto ) // 중간연산
                .orElse(null); // 만약에 조회 실패하면 null 반환

        return todoDto;
    }

    // 3. title 개별 조회
    public TodoDto query1( String title ){
        // * findById 밖에 없으므로 리포지토리에서 findByTitle 만들자.
        // 2-1] 쿼리 메소드 호출
        TodoEntity entity = todoRepository.findByTitle( title );
        // 3-1] 네이티브 호출
        TodoEntity entity1 = todoRepository.query1( title );
        return entity.toDto();
    }

    // 4. title 과 content 개별 조회
    public Map<String, Object> query2(
            String title , String content ) {
        // 2-2] 쿼리 메소드 호출
//        Map<String,Object> result = todoRepository.findByTitleAndContent(title,content);
//        System.out.println("result = " + result.toString());
//
//        return todoRepository.findByTitleAndContent( title,content);

        // 3-2] 네이티브 메소드 호출
        return todoRepository.query2(title, content);
    }

    // 5. title 이 포함된 개별 조회
    public List<TodoDto> query3(String title){
        // List<TodoEntity> entityList = todoRepository.findByTitleContaining(title); // 2-3]
        List<TodoEntity> entityList = todoRepository.query3(title); // 3-3]
        return entityList.stream() // 스트링 시작
                .map( TodoEntity :: toDto ) // 중간연산 , 메소드 레퍼런스 API , 중간연산
                .collect(Collectors.toList()); // 최종출력은 List 타입
    }

    // 6. Page 인터페이스 이란 ? 페이징 처리 정보 담는 인터페이스
    public Page<TodoDto> page(int page, int size){
        // 1] 페이징 옵션 설정한다. PageRequest 구현체 , .of(조회할페이지번호 , 페이지당개수 , 정렬 );
        // page-1: JPA는 페이징번호가 0부터 시작함으로써 1페이지는 0 , 2페이지는 1 , 3페이지 2
        // size : 현재 (한) 페이지에 조회할 자료/엔티티 개수
        // Sort.by( Sort.Direction.ASC/DESC m , "정렬기준필드명" ) : 'id'라는 속성명
        PageRequest pageRequest = PageRequest.of(page-1 , size , Sort.by(Sort.Direction.DESC , "id" ));
        // 2] findXXX( paseRequest ) 구현체를 포함한다.
        Page<TodoEntity> entityPage = todoRepository.findAll( pageRequest ); // 전체 조회에 대한 페이징처리
        System.out.println("entityPage.getContent() = " + entityPage.getContent());// page.content : 조회된 엔티티들(List)
        System.out.println("entityPage.getTotalPages() = " + entityPage.isEmpty());    // page.empty : 조회 실패 또는 없으면 true , 아니면 false
        System.out.println("entityPage = " + entityPage.getTotalElements());    // page.totalElements : 전체 자료 개수
        System.out.println("entityPage.getTotalPages() = " + entityPage.getTotalPages());// page.totalPages : 전체 페이징 개수

        // 3] Page<엔티티> --> Page<Dto> 변환하기
        return entityPage.map(TodoEntity :: toDto ); // map 과 레퍼런스 API 이용한 변환
        // return entityPage.map( entity -> entity.toDto() ); 이것도 맞음
    }
    // 7. 페이징처리2
    public Page< TodoDto > page2(String keyword , int page , int size ){
        PageRequest pageRequest = PageRequest.of(page-1 , size , Sort.Direction.DESC , "id" ); // 1] 페이징 옵션 (구현체) 만든다.
        // 2] 전체조회 인지?? 키워드 조회인지??
        Page<TodoEntity> result; // 조회결과 담는 Page 타입
        if(keyword==null || keyword.isBlank() ){ // 만약에 키워드가 비어있으면 전체조회
            result = todoRepository.findAll(pageRequest); // 전체조회 + 페이징처리
        }else{ // 아니면 키워드 조회
            result = todoRepository.query4( keyword , pageRequest ); // 개별조회메소드 생성 + 페이징처리
        }
        return result.map( TodoEntity :: toDto );
    }



} // class END


