package example.day06.entity;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsService {
    @Autowired
    private GoodsRepository goodsRepository;
    // 1. 저장
    public boolean 저장( GoodsDto goodsDto ){

    }

    // 2. 수정 ** @Transactional 필수 **
    @Transactional // 수정시 여러개 setter 사용함으로 단일 실행
    public boolean 수정( GoodsDto goodsDto ){

    }
}
