package example.종합.예제8.model.dao;



import example.종합.예제8.model.dto.BoardDto;


import java.sql.*;
import java.util.ArrayList;

public class BoardDao {
    // 싱글톤 생성
    private BoardDao(){connect();} // 생성자  private / dao 생성자에서 연동 함수 실행
    private static final BoardDao instance = new BoardDao(); // 현재 객체를 new해서 instance 하나만듦 글구 private로 막음

    public static BoardDao getInstance(){ return instance; } // public으로 해서 행당하는 instance를 반환함

    // ================ 데이터베이스 연동 =============== //
    // 1) 연동할 db서버의 정보
    private String url = "jdbc:mysql://localhost:3306/boardservice7";
    private String user = "root";
    private String password = "1234";

    // 2) 연동 인터페이스 변수 선언
    private Connection conn;
    // 3) 연동 함수 정의 , dao 생성자에서 실행 ( dao 싱글톤이 생성되면서 db 연동 실행 )
    private void connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // mysql 라이브러리 객체 메모리 할당/불러오기
            conn = DriverManager.getConnection( url , user , password ); // mysql 구현체로 db연동 후 연동 인터페이스에 반환
            System.out.println("[시스템 준비] 데이터베이스 연동을 성공하였습니다.");
        }catch ( Exception e ){
            System.out.println("[시스템 경고] DB 연동 실패 : 관리자에게 문의하십시오.");}
    }

    // [1] 게시물 등록 dao
    public boolean write(String bcontent,String bwriter) {
        try{
            // 1) SQL 작성한다. 저장 -> C -> INSERT , ? : 와일드카드 기호로 변수값이 들어갈 자리를 뜻한다.
            String sql = "insert into board(bcontent,bwriter) values(?,?)";
            // 2) 연동된(Conn) 인터페이스에 내가 작성한 sql 기재한다. 반환 preparedStatement 준비된
            PreparedStatement ps = conn.prepareStatement(sql);
            // 3) SQL이 기재된(ps) 인터페이스에서 sql 매개변수를 대입한다. // ps.set타입명( ?순서번호 , 값 );
            ps.setString( 1 , bcontent ); // String 타입으로 SQL 내 1번 ?에 bcontent 값 대입한다.
            ps.setString( 2 , bwriter ); // String 타입으로 SQL 내  2번 ?에 bwriter 값 대입한다.
            // 4) 매개변수까지 대입하여 준비가 끝났으면 SQL 실행 , ps.executeUpdate(); 반환값은 반영된 레코드수
            int count = ps.executeUpdate();
            // 5) SQL 실행 후 반영된 레코드 수에 따른 결과
            if(count==1){return true;} // 등록한 레코드 수가 1이면 등록성공
            else{return false;} // 아니면 실패

        }catch (SQLException e){
            System.out.println("[시스템 오류] SQL 문법 문제 발생 : " + e);
        }
        return false; // 실패
    } // f END


    // [2] 게시물 전체 조회 dao
    public ArrayList<BoardDto> findAll(){
        ArrayList<BoardDto>boards = new ArrayList<>(); // 조회 결과 레코드(DTO)를 저장할 리스트/배열 선언
        try{
            // 1. SQL 작성한다.
            String sql = "select * from board";
            // 2) SQL 기재
            PreparedStatement ps = conn.prepareStatement(sql);
            // 3) SQL 매개변수 : 물음표 없으므로 생략!
            // 4) SQL 실행 , executeUpdate() 쓰는 애들 : insert/update,delete  vs  executeQuery() : select
            ResultSet rs = ps.executeQuery(); // sql 실행 후 몇개 조회했는지가 아닌 조회 결과 테이블을 제어해야 하기 때문.
            // 변수명을 rs라 하고 결과물을 담는다.
            // ResultSet : select 결과물을 제어하는 인터페이스
            // rs.next() : 조회 결과에서 다음 레코드로 1번 이동 , 만약에 레코드가 10개이면 next는 10번
            while (rs.next()){ // while(논리){ } 반복문 ,
                // rs.get타입명( 속성명 )   : 현재 레코드의 속성값 호출
                int bno = rs.getInt("bno");
                String bcontent = rs.getString("bcontent");
                String bwriter = rs.getString("bwriter");
                String bdate = rs.getString("bdate");
                // DTO(객체) 만들기
                BoardDto boardDto = new BoardDto(bno,bcontent,bwriter,bdate);
                // 리스트(배열)에 생성한 DTO 레코드 저장
                boards.add(boardDto);
            } // w END
        }catch (SQLException e ){
            System.out.println("[시스템 오류] SQL 문법 문제 발생 : " + e);
        } return boards; // 리스트(배열) 반환한다.
    } // m end
    // [3] 게시물 수정 dao
    public boolean update(int bno , String bcontent ){
        try{
            // 1) SQL 작성한다, ? ? 는 매개변수가 들어갈 자리
            String sql = "update board set bcontent = ? where bno = ?";
            // 2) SQL 기재
            PreparedStatement ps = conn.prepareStatement(sql);
            // 3) SQL 매개변수
            ps.setString(1,bcontent);
            ps.setInt(2,bno);
            // 4) SQL 실행
            int count = ps.executeUpdate();
            // 5) 결과
            if(count==1){return true;} // 1개의 레코드가 수정했다면 성공
            else {return false;} // 아니면 실패
        }catch (SQLException e){
            System.out.println("[시스템 오류] SQL 문법 문제 발생 : "+e);
        }
        return false; // 오류가 나도 실패
    }

    // [4] 게시물 삭제 dao
    public boolean delete(int bno){
        try {
            // [1] SQL 작성한다, ? 는 매개변수가 들어갈 자리
            String sql = "delete from board where bno = ? ";
            // [2] 연동된[conn] 인터페이스에 sql 기재한다.
            PreparedStatement ps = conn.prepareStatement(sql);
            // [3] ? 와일드카드에 매개변수 대입, ps.setXXX(?순서번호 , 값);
            ps.setInt(1,bno);
            // [4] SQL 실행한다. , 실행 후 반영된 레코드 수
            int count = ps.executeUpdate(); // 몇개를 실행했는지 반영도 알려줌  / excute() : 실행을 했다 안 했다 까지만 알려줌
            // [5] 결과
            if(count==1){return true;} // 삭제된 레코드 수 1개이면 성공
            else {return false;} // 실패
        }catch (SQLException e){
            System.out.println("[시스템 오류] SQL 문법 문제 발생 : "+e);}
        return false; // 실패
    }
} // class END