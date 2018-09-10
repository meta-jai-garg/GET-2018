package com.metacube.training.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.training.model.Address;

public class AddressMapper implements RowMapper<Address> {

	@Override
	public Address mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
		Address address = new Address();
		address.setAddressId(resultSet.getInt("addressId"));
		address.setAddLine1(resultSet.getString("addLine1"));
		address.setAddLine2(resultSet.getString("addLine2"));
		address.setCity(resultSet.getString("city"));
		address.setEmpCode(resultSet.getInt("empCode"));
		address.setPincode(resultSet.getString("pincode"));
		address.setState(resultSet.getString("state"));
		return address;
	}

}
