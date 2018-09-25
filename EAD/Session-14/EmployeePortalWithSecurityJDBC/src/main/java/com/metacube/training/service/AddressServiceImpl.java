package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.model.Address;
import com.metacube.training.repository.AddressRepository;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressRepository addressRepo;

	@Override
	public Address getById(Integer id) {
		return addressRepo.findById(id).get();
	}

	@Override
	public Address getByEmployeeId(Integer id) {
		return addressRepo.getByEmpCode(id);
	}

	@Override
	public List<Address> getAll() {
		return null;
	}

	@Override
	public boolean create(Address address) {
		addressRepo.save(address);
		return true;
	}

	@Override
	public boolean update(Address address) {
		addressRepo.save(address);
		return true;
	}

	@Override
	public boolean delete(Integer id) {
		return false;
	}

}