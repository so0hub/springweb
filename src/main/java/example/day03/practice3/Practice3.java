package example.day03.practice3;

import lombok.*;

public class Practice3 {
    public static void main(String[] args) {

        AttendanceDto attendanceDto1 = new AttendanceDto(); // 객체 생성
        AttendanceDto attendanceDto2 = new AttendanceDto(1, "박진감", "2026-02-26", "결석");


        AttendanceDto attendanceDto3 = AttendanceDto.builder().ano(1).studentName("박진감").date("2026-02-26").status("결석").build();
        AttendanceDto attendanceDto4 = AttendanceDto.builder().studentName("박진감").ano(2).build();
        AttendanceDto attendanceDto5 = AttendanceDto.builder().status("결석").studentName("박진감").build();
    }
}

