package example.day02.practice1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.servlet.context.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan // 서블릿 클래스 스캔하여 등록한다.
public class AppStart {
    public static void main(String[] args) {
        SpringApplication.run(AppStart.class);
        System.out.println(AppStart.class);
    }


}

