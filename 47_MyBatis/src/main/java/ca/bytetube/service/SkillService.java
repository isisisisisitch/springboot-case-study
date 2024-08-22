package ca.bytetube.service;

import ca.bytetube.domain.Skill;

import java.util.List;

public interface SkillService {
    boolean save(Skill skill);
    List<Skill> list();
    Skill get(Integer id);
    boolean remove(Integer id);
}
