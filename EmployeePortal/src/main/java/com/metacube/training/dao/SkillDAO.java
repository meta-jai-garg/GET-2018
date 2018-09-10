package com.metacube.training.dao;

import java.util.List;

import com.metacube.training.model.Skill;

public interface SkillDAO {

	/**
	 * method to find {@link Skill}
	 * 
	 * @param SkillId
	 *            of {@link Skill}
	 * @return {@link Skill}
	 */
	Skill getSkillById(Integer id);

	/**
	 * method to retrieve all {@link Skill}
	 * 
	 * @return list of {@link Skill}
	 */
	List<Skill> getAllSkills();

	/**
	 * method to delete an {@link Skill}
	 * 
	 * @param Skill
	 *            is object of {@link Skill}
	 * @return true on successful deletion of Skill
	 */
	boolean deleteSkill(Skill Skill);

	/**
	 * method to update an {@link Skill}
	 * 
	 * @param Skill
	 *            is object of {@link Skill}
	 * @return
	 */
	boolean updateSkill(Skill Skill);

	/**
	 * method to create an {@link Skill}
	 * 
	 * @param Skill
	 *            is object of {@link Skill}
	 * @return true on successful insertion of {@link Skill}
	 */
	boolean createSkill(Skill Skill);
}