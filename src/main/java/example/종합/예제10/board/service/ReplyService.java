package example.종합.예제10.board.service;
import example.종합.예제10.board.dto.ReplyDto;
import example.종합.예제10.board.entity.ReplyEntity;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import example.종합.예제10.board.repository.ReplyRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReplyService {
    @Autowired
    private ReplyRepository replyRepository;
    // **************************************
    // 1. 댓글 등록
    public boolean 댓글등록(ReplyDto replyDto){
        // 1. 저장할 dto --> entity 변환한다.
        ReplyEntity rsaveEntity = replyDto.rtoEntity();
        // 2. JPA 이용한 entity 저장
        rsaveEntity = replyRepository.save(rsaveEntity);
        // 3. pk 생성여부 판단
        if(rsaveEntity.getRno()>=1) return true;
        return false;
    }

    // 2. 댓글 전체 조회
    public  List<ReplyDto> 댓글전체조회(){
        List<ReplyEntity> entityList = replyRepository.findAll();
        List<ReplyDto> list = new ArrayList<>();
        entityList.forEach( entity ->
        { ReplyDto replyDto = entity.rtoDto();
            list.add(replyDto);
        });
        return list;
    }


}
