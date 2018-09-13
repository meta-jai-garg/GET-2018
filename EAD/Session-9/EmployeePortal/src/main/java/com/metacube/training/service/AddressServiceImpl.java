package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.dao.AddressDAO;
import com.metacube.training.mapper.AddressMapper;
import com.metacube.training.model.Address;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressDAO addressDao;

	@Override
	public Address getById(Integer id) {
		return addressDao.getById(id);
	}

	@Override
	public Address getByEmployeeId(Integer id) {
		return addressDao.getByEmployeeId(id);
	}

	@Override
	public List<Address> getAll() {
		return null;
	}

	@Override
	public boolean create(Address address) {
		return addressDao.create(address);
	}

	@Override
	public boolean update(Address address) {
		System.out.println(address.toString());
		return addressDao.update(address);
	}

	@Override
	public boolean delete(Integer id) {
		return false;
	}

}