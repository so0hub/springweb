package example.day03.어노테이션;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

class SuperClass{ void method(){} } // 상위 클래스
class SubClass extends SuperClass{ // 하위 클래스
    @Override void method() { }  // 상위 클래스로부터 물려받은 메소드 재정의 알리는 어노테이션
    @Deprecated void method2( ){ } // 더이상 사용하지 않는 메소드 알리는 어노테이션
}
// [ 어노테이션 만들기 ] : 인터페이스 기반
@Retention( RetentionPolicy.RUNTIME) // 해당 어노테이션이 실행되는 시점
@Target(ElementType.METHOD ) // 해당 어노테이션을 주입할 코드
@interface MyAnnotation{
    String value1(); // 구현부가 없는 추상메소드
}
// [ 어노테이션 사용하기 ] : 내가만든 어노테이션 사용
class TestClass{
    @MyAnnotation( value1 = "주입하는값" ) // @어노테이션이란? 해당 기술 사용하기 위한 설명
    public void method(){ } // 메소드  : 만약에 해당 메소드가 실행되면 @MyAnnotation에 포함된 기능들이 실행
}

public class Exam1 {
    public static void main(String[] args) {
        // ** 스프링 기능이 아닌 자바의 어노테이션 설명 **
        // 어노테이션 개념만 익히기

        /*
            @ 어노테이션
            1. 정의 : 자바 에서 코드의 메타데이터를 추가하는 문법 * 메타데이터란? 특정한 데이터를 설명하는 데이터
            2. 목적 : 1.메타데이터 제공 2.코드 간소화 3.가독성 향상
            3. 종류
                1. 표준 어노테이션 : 자바에서 기본적으로 제공하는 어노테이션
                    @Override : 상위 클래스로부터 메소드를 재정의
                2. 메타 어노테이션 : 코드를 정의하거나 동작 제어할때 사용 되는 어노테이션
                    스프링 프레임워크
            4. 어노테이션 만들기
                1. @interface 어노테이션{ }
                2. 인터페이스 위에 유지기간,실행위치 설정
                   1] @Retention( RetentionPolicy.RUNTIME ) : 프로그램 실행중 유지 뜻
                       @Retention( RetentionPolicy.CLASS ) : .class 파일에 포함 뜻 ,
                       @Retention( RetentionPolicy.SOURCE) : 컴파일(코드->번역) 이후에 까지만 유지 뜻
                   2]  @Target( ElementType.TYPE ) : 클래스 에서 사용
                       @Target( ElementType.METHOD ) : 메소드 에서 사용
                       @Target( ElementType.FIELD ) : 멤버변수 에서 사용
                        등등
            5. 스프링 어노테이션
                @ 어노테이션 활용 : 개발자는 단순한 어노테이션 전달 함으로써 내부적으로 복잡한 코드가 실행된다.
                개발자입장                           스프링 프레임워크
                    @RestController ------------>   @RestController 추상한 구현체(클래스)들이 자동 실행 ( 동적 로딩 )
            6. 동적 로딩 이란? 리플렉션 , 실행중에 클래스를 읽어와서 객체 생성 과정
                Class.forName( "com.mysql.cj.jdbc.Driver" ) : jdbc연동에 필요한 Driver 객체 생성한다.
        */
    }
} // class end