package com.metacube.training.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.metacube.training.model.Skill;

public interface SkillRepository extends JpaRepository<Skill, Integer> {
	Skill findSkillBySkillName(String skillName);
	@Query("select s from Skill s where s.skillId NOT IN(select skillCode from EmployeeSkills where empCode=:empCode)")
	List<Skill> findSkillByEmpCode(@Param("empCode") Integer empCode);
}
