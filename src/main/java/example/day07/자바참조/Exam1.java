package example.day07.자바참조;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

public class Exam1 {
    public static void main(String[] args) {

        // 자바는 객체지향 언어이다.
        // System : 클래스 , System.out : 객체 , println( ) : 함수/메소드
        // 즉] 특정한 객체가 특정한 함수 실행한다. // . 참조
        System.out.println("출력함수");

        // [1] 카테고리 객체 생성 == 클래스(설계도)로 메모리(인스턴스) 생성한다는 뜻
        // 동일한 클래스(설계도)로 서로 다른 객체(인스턴스) 생성한다.
        Category category = new Category(); // new = 객체 1개 //
        category.setCno(1); category.setCname("공지사항");

        Category category2 = new Category(); // 또 다른 객체 1개 // 클래스는 하나이지만 객체는 두 개!!
        category.setCno(2); category2.setCname("자유게시판");

        // [2] 게시물 객체 생성 , 참조란? 다른 값 접근(참고)한다. [ FK ]
        // 즉] ORM(JPA) 기술은 이러한 객체참조로 데이터베이스의 PK-FK 구현
        // 단방향 : FK를 통해 PK를 참조하는 것처럼 , 특정한 객체를 통해 참조 객체를 조회(참조)한다.
        // 즉] 게시물 객체 통해 카테고리 객체 참조한다. * 카테고리 객체를 통해 게시물 객체는 참조 못 한다.
        // 2-1 : 첫 번째 게시물은 공지사항 이다.
        Board board = new Board(); // 201호
        board.setBcontent("첫 번째 게시물입니다."); // 첫 번째 카테고리 객체(공지사항)를 게시물 객체에 대입한다.
        board.setCategory( category ); // 201호 안에 101호 참조

        // 2-1 : 두 번째 게시물은 자유게시판이다.
        Board board2 = new Board(); // 202호
        board2.setBcontent("두 번째 게시물입니다.");
        board2.setCategory( category2 ); // 202호 안에 102호 참조

        // [3] 카테고리가 게시물 참조
        // 양방향 참조 , 두 객체 간의 서로 참조하는 관계 , 데이터베이스 존재하지 않는다.
        // 즉] ORM(JPA)는 단방향/양방향 모두 지원한다. 특징 : 조회가 빠르다.
        // 1. 순환참조 문제점 고려 2. 복잡한 JOIN 3. LAZY 지연 로딩 고려
        category.getBoardList().add( board ); // 101호에 201호 참조 대입한다.
        category2.getBoardList().add( board2 ); // 102호에 202호 참조 대입한다.

        // 확인
        System.out.println( board2.getCategory() ); // FK에서 PK 단방향 참조/조회
        // stackOverFlowError : 양방향 참조하다가 메모리 넘쳤다는 오류
        // 해결방안 : 두 객체 간의 한 쪽 필드에   @ToString.Exclude 라고 주입한다. ******************
        System.out.println( category.getBoardList() ); // PK에서 FK 양방향 참조/조회


    } // m END
} // class END

@Data // 롬복
class Category{ // 클래스는 한 개!!!
    private int cno; // 카테고리 번호
    private String cname; // 카테고리 이름
    @ToString.Exclude // 순환참조 방지하는 것 **********************
    private List<Board> boardList = new ArrayList<>(); // 양방향 참조, 게시물 목록
}

@Data // 롬복
class Board{
    private  int bno;
    private  String Bcontent;
    private Category category; // 단방향 참조 , FK 느낌 // 보드가 카테고리를 참조한다.
}





























