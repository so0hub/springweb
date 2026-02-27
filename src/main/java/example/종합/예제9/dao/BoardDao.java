package example.종합.예제9.dao;

import example.종합.예제9.dto.BoardDto;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Component // 빈 등록
public class BoardDao {
    public BoardDao(){connect();}
    // ================ 데이터베이스 연동 =============== //
    // 1) 연동할 db서버의 정보
    private String url = "jdbc:mysql://localhost:3306/boardservice9";
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


    // 1] 전체조회
    public List<BoardDto> findAll( ){
        List<BoardDto> list = new ArrayList<>();               // 1]조회 결과 레코드들을 DTO로 저장하기 위한 리스트선언
        try{
            String sql = "select * from board";                 // 2] SQL 작성
            PreparedStatement ps = conn.prepareStatement( sql ); // 3] SQL 등록
            ResultSet rs = ps.executeQuery();                    // 4] SQL 실행하고 결과 받기
            while ( rs.next() ){                                 // 5] 첫번째 레코드 부터 마지막 레코드까지 반복
                BoardDto boardDto = new BoardDto(                // 6] 조회중인 레코드의 속성정보들을 DTO 구성
                        rs.getInt("bno") , rs.getString("bcontent") ,
                        rs.getString("bwriter") , rs.getString("bdate") );
                list.add( boardDto );                           // 7] 구성한 DTO를 리스트 저장
            }
        } catch (Exception e) { System.out.println(e); }
        return list;                                             // 8] 리스트 반환
    } // m end

    // 2] 게시물 등록
    public boolean write(BoardDto boardDto){
        try{
            String sql = "insert into board(bcontent,bwriter) values(?,?)";    // 1] SQL 작성한다.
            PreparedStatement ps = conn.prepareStatement(sql);                 // 2] SQL 등록한다.
            ps.setString(1,boardDto.getBcontent());  // 3] SQL 첫 번째 매개변수 ?에 값 대입한다.
            ps.setString(2,boardDto.getBwriter());  // 3] SQL 두 번째 매개변수 ?에 값 대입한다.
            int count = ps.executeUpdate();                     // 4] SQL 실행하고  반영한 레코드 수 저장한다.
            if(count==1)return true;                            // 5] 반영한 레코드수가 1이면 성공
        }catch (Exception e){
            System.out.println(e);
        }
        return false;            // 6] 아니면 실패
    }



    // 3] 게시물 개별 수정
    public boolean update( BoardDto boardDto ){
        try{
            String sql = "update board set bcontent = ? where bno = ?";
            PreparedStatement ps = conn.prepareStatement( sql );
            ps.setString( 1 , boardDto.getBcontent() );
            ps.setInt( 2 , boardDto.getBno() );
            int count = ps.executeUpdate();
            if( count == 1 ) return true;
        } catch (Exception e) {System.out.println(e);}
        return false;
    }

    // 4] 게시물 개별 삭제
    public boolean delete(int bno){
        try {
            String sql = "delete from board where bno = ? ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,bno);
            int count = ps.executeUpdate();
            if(count==1) return true;
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }

}
