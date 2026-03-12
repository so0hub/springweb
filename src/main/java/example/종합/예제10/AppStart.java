package example.종합.예제10;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing // JPA 감사 기능 활성화 : baseTime 적용하기 위해 씀
public class AppStart {
    public static void main(String[] args) {
        SpringApplication.run(AppStart.class);
    }

}

/*
sample sql 생성해서 이거 번개 치고 실행

drop database if exists boardservice10;
create database boardservice10;
use boardservice10;

select * from board;

*/
