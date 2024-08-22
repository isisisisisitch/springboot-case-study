package ca.bytetube.controller;

import ca.bytetube.domain.Cat;
import ca.bytetube.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableConfigurationProperties({Student.class, Cat.class})
public class TestController {
    @Value("${name1}")
    private String name;
    @Autowired
    private Cat cat;

    @Autowired
    private Student student;

    @GetMapping("/test")
    public String test() {
        System.out.println(student);
        return "test!!!"+cat;
    }
}
