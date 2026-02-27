package example.종합.예제9.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@NoArgsConstructor // 매개변수 없는 자동 생성
@AllArgsConstructor // 전체매개변수 생성자 자동 생성
@Data // setter + getter + toString + RequiredArgsConstructor(final 멤버변수 생성자)
public class BoardDto {
    // 멤버변수 : 데이터베이스의 속성명과 일치, +기능에 따라 추가
    private Integer bno; // int -> Integer 사용하여 null 값 대응
    private String bcontent;
    private String bwriter;
    private String bdate;
}
