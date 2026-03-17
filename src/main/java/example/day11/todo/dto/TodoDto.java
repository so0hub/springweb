package example.day11.todo.dto;

import example.day11.todo.entity.TodoEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder @NoArgsConstructor @AllArgsConstructor // 롬복
public class TodoDto {
    // 데이터베이스 데이터를 이동하는 객체
    // 기능 구현에 필요한 목적에 따른 이동할 데이터 구성
    // 실무: 1) 테이블유사 2) 기능/상황 별 <---> MAP
    private Integer id; // R U
    private String title; // C R U
    private String content; // C R U
    private Boolean done; // C R U
    private String createDate; // R
    private String updateDate; // R
    private Integer cno;

    // + Dto --> Entity 변환 : C
    public TodoEntity toEntity(){
        return TodoEntity.builder()
                .title( this.title )
                .content( this.content )
                .done( this.done )
                .build();
    }

}

