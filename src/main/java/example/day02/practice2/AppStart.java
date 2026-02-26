package example.day02.practice2;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // 1.내장톰캣설정 2.컴포넌트(MVC) 스캔
public class AppStart {
    public static void main(String[] args) {
        SpringApplication.run( AppStart.class );
    }
}
