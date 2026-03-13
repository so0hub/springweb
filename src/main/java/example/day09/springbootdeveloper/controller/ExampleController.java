package example.day09.springbootdeveloper.controller;

import org.springframework.ui.Model;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
// 임포트하기

import java.time.LocalDate;
import java.util.List;

@Controller
public class ExampleController {
    @GetMapping("/thymeleaf/example")
    public String thymeleafExample(Model model){ // 뷰로 데이터를 넘겨주는 모델 객체
        Person examplePerson = new Person();
        examplePerson.setId(1L);
        examplePerson.setName("박진감");
        examplePerson.setAge(1);
        examplePerson.setHobbies(List.of("옷뜯기","츄르먹기"));

        model.addAttribute("person",examplePerson); // Person 객체 저장
        model.addAttribute("today", LocalDate.now());

        return "example"; // example.html 이라는 뷰 조회

    }
    @Setter
    @Getter
    class Person{
        private long id;
        private String Name;
        private int age;
        private List<String> hobbies;
    }

}
