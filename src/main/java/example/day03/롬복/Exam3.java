package example.day03.롬복;

import lombok.*;

public class Exam3 {
    public static void main(String[] args) {

/*

롬복 lombok
: 반복되는 코드들을 줄여주는 라이브러리
   1. 인텔리제이에서 설치 (플러그인 -> 'lombok')
   2. 프로젝트 의존성 추가
      1. http://start.spring.io
      2.Dependencies 에서 'lombok' 검색 후 추가
      3. [EXPLORE] -> 롬복 관련
        compileOnly 'org.projectlombok:lombok'
        annotationProcessor 'org.projectlombok:lombok'
      4. 프로젝트 내 build.gradle 파일에 depende
      5. build.어쩌고 새로고침
      ``` */
        StudentDto studentDto1 = new StudentDto(); // new를 사용하여 객체 만들기
        StudentDto studentDto2 = new StudentDto( 1, "홍길동" );
        studentDto2.getSname();
        studentDto2.setSname("되네");
        studentDto2.toString();
/*```
- 생성자는 매개변수의 순서대로 인자값을 전달한다. 그래서 유연성이 떨어진다.
   - 예) (X) `StudentDto studentDto2 = new StudentDto( "홍길동", 1 );`
   - 해결책: 빌더패턴 `@Builder`
     - 객체를 만드는 패턴. 유연성을 제공한다.
     - `클래스명.builder().멤버변수명(값).멤버변수명(값).build();`
     - 장점: 생성자와 달리 순서가 바뀌어도 된다.
     - 단점: 별도의 유효성 검사가 필요하다.        */
        StudentDto studentDto4 = StudentDto.builder().sno( 1 ).sname( "홍길동" ).build();
        StudentDto studentDto5 = StudentDto.builder().sname( "홍길동" ).sno( 2 ).build();
        StudentDto studentDto6 = StudentDto.builder().sname( "홍길동" ).build(); // 헐 넣고 싶은 것만 넣어도 됨 헐 😂
    }
}
// 롬복 라이브러리에 뭐 있을까요~
@NoArgsConstructor  // 컴파일(코드번역될때) 기본생성자 코드 자동 생성
@AllArgsConstructor // 컴파일(코드번역될때) 전체매개변수생성자 코드 자동 생성
// @RequiredArgsConstructor // final 매개변수 생성자 자동 생성 (@Data에 있음)
@Getter // 컴파일(코드번역될때) getter 메소드 제공 (@Data에 있음)
@Setter // 컴파일(코드번역될때) setter 메소드 제공 (@Data에 있음)
@ToString // 컴파일(코드번역될때) ToString 메소드 제공 (@Data에 있음)
//@Data = @Getter + @Setter + @ToString + @RequiredArgsConstructor . 그래서 @Data 사용할 때는 다 생략하고 세 개만 쓰면 됨.
@Builder // 빌더패턴 사용
class StudentDto{
    // 1. private 멤버변수
    private int sno;
    private String sname;
    // 2. 빈생성자 , 풀생성자
    // 3. getter/setter
    // 위 두 개는 이제 어노테이션으로 끝남!~~ 우왕
}