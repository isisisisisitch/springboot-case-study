package ca.bytetube.controller;

import ca.bytetube.domain.JdbcProperties;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Data
public class TestController {

//    //@Value("${name}")
//    private String name = "bytetube";
    @Autowired
    private JdbcProperties jdbcProperties;

    @GetMapping("/test")
    public String test() {

        return jdbcProperties.toString();
    }
}
