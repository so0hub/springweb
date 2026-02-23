package example.종합.예제8.model.dto;

public class BoardDto {
    // 멤버변수 : 데이터베이스의 속성명과 일치, +기능에 따라 추가
    private int bno;
    private String bcontent;
    private String bwriter;
    private String bdate;

    // 기본생성자1  , 전체매개변수생성자 ,  +기능에 따라 필요한 생성자
    public BoardDto(){} // 기본 생성자

    // 오른쪽 클릭하고 전체생성자
    public BoardDto(int bno,String bcontent, String bwriter, String bdate) {
        this.bcontent = bcontent;
        this.bwriter = bwriter;
        this.bdate = bdate;
        this.bno = bno;
    }

    // getter setter , toString 만들기

    public int getBno() {return bno;}
    public void setBno(int bno) {this.bno = bno;}
    public String getBcontent() {return bcontent;}
    public void setBcontent(String bcontent) {this.bcontent = bcontent;}
    public String getBwriter() {return bwriter;}
    public void setBwriter(String bwriter) {this.bwriter = bwriter;}
    public String getBdate() {return bdate;}
    public void setBdate(String bdate) {this.bdate = bdate;}

    @Override
    public String toString() {
        return "BoardDto{" +
                "bno=" + bno +
                ", bcontent='" + bcontent + '\'' +
                ", bwriter='" + bwriter + '\'' +
                ", bdate='" + bdate + '\'' +
                '}';
    }
}
