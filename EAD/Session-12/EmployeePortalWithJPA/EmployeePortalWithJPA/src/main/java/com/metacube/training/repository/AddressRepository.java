package com.metacube.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metacube.training.model.Address;

public interface AddressRepository extends JpaRepository<Address, Integer>{
	Address getByEmpCode(Integer id);
}