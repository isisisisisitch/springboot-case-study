package ca.bytetube.controller;

import ca.bytetube.service.SkillService;
import ca.bytetube.domain.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/skills")
public class SkillController {
    @Autowired
    private SkillService service;

    @GetMapping("/list")
    public List<Skill> list() {
        return service.list();
    }

    @GetMapping("/get")
    public Skill get(Integer id) {
        return service.get(id);
    }

    @PostMapping("/save")
    public String save(Skill skill) {
        String[] msgs;
        Integer id = skill.getId();
        if (id != null && id > 0) {
            msgs = new String[] {"Update successfully", "Update failure"};
        } else {
            msgs = new String[] {"save successfully", "save failure"};
        }
        return service.save(skill) ? msgs[0] + "_" + skill.getId() : msgs[1];
    }

    @PostMapping("/remove")
    public String remove(Integer id) {
        return service.remove(id) ? "remove successfully" : "remove failure";
    }
}
