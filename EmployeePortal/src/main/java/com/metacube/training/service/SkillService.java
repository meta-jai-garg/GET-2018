package com.metacube.training.service;

import java.util.List;

import com.metacube.training.model.Skill;

public interface SkillService {

	/**
	 * Method to find {@link Skill} by id
	 * 
	 * @param SkillId
	 *            id of {@link Skill}
	 * @return {@link Skill} object
	 */
	Skill getSkillById(Integer SkillId);

	/**
	 * Method to retrieve all {@link Skill}
	 * 
	 * @return all {@link Skill}
	 */
	List<Skill> getAllSkills();

	/**
	 * Method to delete a {@link Skill}
	 * 
	 * @param id
	 *            of {@link Skill}
	 * @return true on successful deletion
	 */
	boolean deleteSkill(Integer id);

	/**
	 * Method to update a {@link Skill}
	 * 
	 * @param Skill
	 *            is object of {@link Skill}
	 * @return true on successful update
	 */
	boolean updateSkill(Skill Skill);

	/**
	 * Method to create a {@link Skill}
	 * 
	 * @param Skill
	 *            is object of {@link Skill}
	 * @return true on successful update
	 */
	boolean createSkill(Skill Skill);
}