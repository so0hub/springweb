package example.day03.practice3;

import lombok.*;

    @Data // getter setter toString
    @Builder // 빌더패턴(생성자 대신에 사용
    @NoArgsConstructor @AllArgsConstructor // 생성자
    public class AttendanceDto {
        private int ano;
        private String studentName;
        private String date;
        private String status;

    }

