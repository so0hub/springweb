package example.day10;

import org.springframework.beans.factory.annotation.Autowired;

class Vip{
    int add3( int a , int b ){
        return a+b;
    }
}

class Member extends Vip{
    int add(int a , int b ){ return a+b; }
    static int add2( int a , int b ){ return a+b; }
    int add3( int a , int b ){
        return a-b;
    }
}

public class Exam1 {
    public static void main(String[] args) {

        // 1. 함수 = 메소드 == 기능 == 방법
        // 2. 종류
            // 2-1) 인스턴스/멤버 메소드 == new 이용하여 인스턴스 생성하여 함수 호출
        Member member = new Member();
        int result = member.add( 3, 4);
            // 2-2) static/정적 메소드 == 인스턴스 생성 없이 함수 호출
        int result2 = Member.add2( 3, 4);
            // 2-3) 오버라이딩 == 상속 또는 구현 받은 타입의 메소드 재정의
        Member member3 = new Member();
        int result3 = member3.add3( 4, 3 );
        // 3. 함수 기존 구조 * 자바는 매개변수/반환값 타입 일치해야 함 *
            // 매개변수 == 인자값저장하는변수 == 함수안으로들어오는값
            // 반환값 == 함수호출했던곳으로함수밖으로되돌려주는값 , int a = 2x; , x = 3
        int result4 = Member.add2( 10 , 5 ); // 10과 5를 인자값 이라고 한다.
        int result5 = Member.add2( 15 , 3 ); // 15와 3을 인자값 이라고 한다.
           // result4 에는 15 반환값이 있을 것 , result5 에는 18 반환값이 있을 것.

        // 4. 함수 호출하는 방법
        // ======================== 다른 클래스일 때 ========================
            new Member().add( 3, 4 ); // 4-1) 인스턴스/멤버 메소드 일 때
            Member.add2( 3 , 4 ); // 4-2) static 메소드일 때
            // Member.getInstance().add( 3 , 4 ); // 4-3) 싱글톤 내 메소드 일 때
            // 4-4) IOC/DI 스프링 구조 메소드일 때
            // @Autowired Member member;
            // member.add5();
        // ======================== 같은 클래스일 때 * static 메소드에서는 불가능 * ========================
            // add6();
            // static 메소드일 때는 static 메솓 ㅡ호출 또는 인스턴스 메소드 호출


    } // main END
} // class END
