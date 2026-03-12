package example.day06.entity;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GoodsService {
    @Autowired
    private GoodsRepository goodsRepository;
    // 1. 저장
    public boolean 저장( GoodsDto goodsDto ){
        // 1] dto --> entity 변환
        GoodsEntity goodsEntity = goodsDto.toEntity();
        // 2] JPA save 이용하여 insert 하기
        GoodsEntity saved = goodsRepository.save( goodsEntity );
        // 3] save 결과에 pk 여부 성공판단
        if( saved.getGno() >= 1 ) return true;
        return false;
    }

    // 2. 수정 ** @Transactional 필수 **
    @Transactional // 수정시 여러개 setter 사용함으로 단일 실행
    public boolean 수정( GoodsDto goodsDto ){
        // 1] 수정할 엔티티의 pk번호 확인한다.
        int updatePk = goodsDto.getGno();
        // 2] 수정할 엔티티 찾기 --> 영속성 , Optional 반환
        Optional< GoodsEntity > optional = goodsRepository.findById( updatePk );
        // 3] 만약에 찾은 엔티티가 존재하면
        if( optional.isPresent() ) {
            GoodsEntity updateEntity = optional.get();    // 4] 엔티티 꺼내기
            updateEntity.setGdesc(goodsDto.getGdesc());
            updateEntity.setGprice(goodsDto.getGprice());
            updateEntity.setGname(goodsDto.getGname()); // 3개 중에 setter 에서 문제 발생시 전체 취소
            return true;
        }else{ return false; }
    }
}
