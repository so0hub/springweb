package example.day12.스프링스레드;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync // 비동기 메소드(스레드) 활성화

public class AppStart {
    public static void main(String[] args) {
        SpringApplication.run(AppStart.class);
    }
}
