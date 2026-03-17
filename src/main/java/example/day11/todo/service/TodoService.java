package example.day11.todo.service;


import example.day11.todo.dto.TodoDto;
import example.day11.todo.entity.TodoEntity;
import example.day11.todo.repository.TodoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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

        // 방법4]
        List<TodoDto> list4 = entityList
                .stream()
                .map( TodoEntity :: toDto ) // 중간연산 , 람다식 대신에 메소드레퍼런스 API( 미리 정의된 메소드 )
                // 클래스명 :: 메소드명
                .collect( Collectors.toList() );

        return  list4;
    }


} // class END

//
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
