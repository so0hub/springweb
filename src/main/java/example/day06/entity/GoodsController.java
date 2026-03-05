package example.day06.entity;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    // 저장
    @PostMapping("/goods")
    public boolean 저장( @RequestBody GoodsDto goodsDto ){
        boolean result = goodsService.저장( goodsDto );
        return result;
    }

    // 수정
    @PutMapping("/goods")
    public boolean 수정( @RequestBody GoodsDto goodsDto ){
        boolean result = goodsService.수정( goodsDto );
        return result;
    }
}
