package ca.bytetube.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @GetMapping("/index")
    public String index() {
        // /test.jsp
        return "test";
    }
}
