package com.metacube.training.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.model.Address;

@Repository
@Transactional
@SuppressWarnings("deprecation")
public class AddressDAOImpl implements AddressDAO {

	@Autowired
	private EntityManager entityManager;

	private Session session;
	
	@Override
	public Address getById(Integer id) {
		createSession();
		return session.get(Address.class, id);
	}

	@Override
	public Address getByEmployeeId(Integer id) {
		createSession();
		Address address = (Address) session.createCriteria(Address.class).add(Restrictions.eq("empCode", id))
				.uniqueResult();
		return address;
	}

	@Override
	public List<Address> getAll() {
		return null;
	}

	@Override
	public boolean create(Address address) {
		createSession();
		session.save(address);
		return true;
	}

	@Override
	public boolean update(Address address) {
		createSession();
		Address updateAddress = (Address) session.createCriteria(Address.class)
				.add(Restrictions.eqOrIsNull("addressId", address.getAddressId())).uniqueResult();
		updateAddress.setAddLine1(address.getAddLine1());
		updateAddress.setAddLine2(address.getAddLine2());
		updateAddress.setCity(address.getCity());
		updateAddress.setState(address.getState());
		updateAddress.setPincode(address.getPincode());
		session.update(updateAddress);
		return true;
	}

	@Override
	public boolean delete(Integer id) {
		return false;
	}

	void createSession() {
		this.session = entityManager.unwrap(Session.class);
	}

}