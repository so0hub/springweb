package example.종합.예제10.board.service;

import example.종합.예제10.board.dto.BoardDto;
import example.종합.예제10.board.entity.BoardEntity;
import example.종합.예제10.board.repository.BoardRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;

    // 1. 등록 , 서비스는 HTTP 담당하지 않는다.
    public boolean 등록( BoardDto boardDto ){
        // 1. 저장할 dto --> entity 변환한다.
        BoardEntity saveEntity = boardDto.toEntity();
        // 2. JPA 이용한 entity 저장
        saveEntity = boardRepository.save(saveEntity);
        // 3. pk 생성여부 판단
        if(saveEntity.getBno()>=1) return true;
        return false;
    } // f END

    // 2. 전체 조회
    public List<BoardDto> 전체조회(){
        // 1] JPA 이용한 모든 엔티티 조회
        List<BoardEntity> entityList =
            boardRepository.findAll();
        // 2] 조회된 모든 entity --> dto 변환
        List<BoardDto> list = new ArrayList<>(); // 여러개 dto 담는 리스트
        // 리스트변수명.forEach( 반복변수 -> { 실행문; } );
        entityList.forEach( entity ->
        { BoardDto boardDto = entity.toDto();  // 3] 엔티티 하나씩 dto 로 변환
            list.add( boardDto ); // 4] 새로운 리스트에 담기
        });
        // 5] 새로운 리스트 반환
        return list;
    }

    // 3. 개별 조회
    public BoardDto 개별조회( int bno ){
        // 1] 조회할 번호(pk/id)의 엔티티 찾기
        Optional<BoardEntity> optional = boardRepository.findById(bno);
        // 2] 만약에 엔티티가 존재하면 , 유효성검사 제공
        if(optional.isPresent()){
            BoardEntity entity = optional.get();
            BoardDto boardDto = entity.toDto(); // 3] entity --> dto 변환
            return boardDto;  // 4] 반환 , 조회 성공
        }
        return null; // 4] 반환 , 조회 실패
    } // f END

    // 4. 개별 수정
    @Transactional // 필수!!!!!!!!!!!!!!!!!
    public boolean 개별수정( BoardDto boardDto ){
        // 1] 수정할 게시물번호로 엔티티 찾기
        Optional<BoardEntity> optional =
        boardRepository.findById(boardDto.getBno());
        // 2] 만약에 엔티티가 존재하면
        if(optional.isPresent()){
            // 3] 엔티티내 멤버변수들을 수정한다 <영속성>
            BoardEntity updateEntity = optional.get();
            updateEntity.setBtitle(boardDto.getBtitle());
            updateEntity.setBcontent(boardDto.getBcontent());
            updateEntity.setBwriter(boardDto.getBwriter());
            return true; // 4] 반환한다. 수정 성공
        }
        return false; // 4] 반환한다. 수정 실패
    }

    // 5. 개별 삭제
    public boolean 개별삭제( int bno ) {
        // 1. 삭제할 게시물번호가 존재하는지 확인
        boolean exists = boardRepository.existsById(bno); // .existsById(pk번호) : 존재하면 true 없으면 false
        // 2. 만약에 존재하면 삭제
        if (exists == true) {
            boardRepository.deleteById(bno);
            return true;
        }
        return false;
    }
}
