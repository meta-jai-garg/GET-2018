package com.metacube.training.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.metacube.training.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	Employee findEmployeeByEmailId(String emailId);

	@Query("select e from Employee e WHERE CONCAT(firstName,' ',lastName) LIKE :input AND isActive=1")
	List<Employee> findEmployeeByName(@Param("input") String input);

	@Query("select e from Employee e where e.empCode IN (select j.empCode from JobDetails j where j.currProjId=:input) AND e.isActive=1")
	List<Employee> findEmployeeByProject(@Param("input") Integer input);

	@Query("select e from Employee e where e.empCode IN (select j.empCode from JobDetails j where j.totalExp >=:input) AND e.isActive=1")
	List<Employee> findEmployeeByTotalExperience(@Param("input") Integer input);

	@Modifying
	@Query("update Employee e set e.isActive=0 where e.empCode=?1")
	void disableEmployee(Integer empCode);
	
	@Modifying
	@Query("update Employee e set e.isActive=1 where e.empCode=?1")
	void enableEmployee(Integer empCode);
}