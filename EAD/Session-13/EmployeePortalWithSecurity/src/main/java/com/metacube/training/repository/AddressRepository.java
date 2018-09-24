package com.metacube.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metacube.training.model.Address;
import com.metacube.training.model.Employee;

public interface AddressRepository extends JpaRepository<Address, Integer> {
	/**
	 * method to find address by Employee Id
	 * 
	 * @param id
	 *            of {@link Employee}
	 * @return {@link Address}
	 */
	Address getByEmpCode(Integer id);
}