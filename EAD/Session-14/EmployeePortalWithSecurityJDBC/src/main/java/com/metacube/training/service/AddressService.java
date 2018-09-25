package com.metacube.training.service;

import java.util.List;

import com.metacube.training.model.Address;

public interface AddressService {
	/**
	 * Used to retrieve a address given its id. Null if no such address found.
	 * 
	 * @param id
	 *            Id of address
	 * @return address with given id
	 */
	public Address getById(Integer id);

	/**
	 * Used to retrieve all Address from the database.
	 * 
	 * @return List of all Address
	 */
	public List<Address> getAll();

	/**
	 * Used to add address to the database.
	 * 
	 * @return Auto generated id of the address inserted, 0 on failure
	 */
	public boolean create(Address address);

	/**
	 * Used to update address in the database.
	 * 
	 * @param address
	 *            to be updated, identified by the id
	 * @return True if address updated, false otherwise.
	 */
	public boolean update(Address address);

	/**
	 * Used to delete address from the database.
	 * 
	 * @param id
	 *            of address to be deleted
	 * @return True if address deleted, false otherwise.
	 */
	public boolean delete(Integer id);

	Address getByEmployeeId(Integer id);
}
