package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.service.SkillService;
import com.metacube.training.dao.SkillDAO;
import com.metacube.training.model.Skill;

@Service
public class SkillServiceImpl implements SkillService {

	@Autowired
	private SkillDAO skillDao;

	@Override
	public Skill getSkillById(Integer skillId) {
		return skillDao.getSkillById(skillId);
	}

	@Override
	public List<Skill> getAllSkills() {
		return skillDao.getAllSkills();
	}

	@Override
	public boolean deleteSkill(Integer id) {
		Skill skill = skillDao.getSkillById(id);
		return skillDao.deleteSkill(skill);
	}

	@Override
	public boolean updateSkill(Skill skill) {
		return skillDao.updateSkill(skill);
	}

	@Override
	public boolean createSkill(Skill skill) {
		return skillDao.createSkill(skill);
	}

}
