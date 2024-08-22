package ca.bytetube.controller;

import ca.bytetube.domain.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.Date;


@Controller
public class TestController {

    @GetMapping("/helloworld")
    public String helloworld(Model model) {
        model.addAttribute("name", "Larry");
        model.addAttribute("age", 22);
        model.addAttribute("msg", "<h1>msg</h1>");
        return "01_helloworld";
    }

//    @GetMapping("/comment")
//    public String comment() {
//        return "02_comment";
//    }

    @GetMapping("/literal")
    public String literal(Model model) {
        model.addAttribute("name", "Larry");
        model.addAttribute("age", 22);
        return "03_literal";
    }


    @GetMapping("/selection")
    public String selection(Model model) {
        model.addAttribute("person", new Person(10, "bytetube"));
        return "04_selection";
    }

//    @GetMapping("/i18n")
//    public String i18n(String name, Integer age) {
//        System.out.println(name);
//        System.out.println(age);
//        return "05_i18n";
//    }

    @GetMapping("/url")
    public String url(Model model) {
        model.addAttribute("id", 6);
        return "06_url";
    }

    @GetMapping("/for")
    public String _for(Model model) {
        model.addAttribute("persons", Arrays.asList(
                new Person(11, "byte11"),
                new Person(22, "byte22"),
                new Person(33, "byte33"),
                new Person(44, "byte44")
        ));
        return "07_for";
    }

    @GetMapping("/attr")
    public String attr(Model model) {
        model.addAttribute("id", 6);
        model.addAttribute("name", "byte");
        return "08_attr";
    }

    @GetMapping("/object")
    public String object(HttpServletRequest request, HttpSession session) {
        request.setAttribute("birthday", new Date());
        request.setAttribute("name", "request_byte");
        session.setAttribute("name", "session_byte");
        session.getServletContext().setAttribute("name", "ctx_byte");
        return "09_object";
    }

//    @GetMapping("/testIndex")
//    public String testIndex(HttpServletRequest request) {
//        // prefix: classpath:/templates/
//        // suffix: .html
//        // classpath:/templates/01_helloworld.html
//        request.setAttribute("name", "bytetube");
//        request.setAttribute("age", 7);
//        return "index";
//    }

    @GetMapping("/testIndex")
    public ModelAndView testIndex() {
        // prefix: classpath:/templates/
        // suffix: .html
        // classpath:/templates/01_helloworld.html
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("name", "bytetube");
        mv.addObject("age", 7);
        return mv;
    }

}
