package com.meta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.meta.model.Advertisement;
import com.meta.model.Category;
import com.meta.util.DbUtil;

public class AdvertisementDao {
	private Connection conn;

	public AdvertisementDao() throws ClassNotFoundException, SQLException {
		conn = DbUtil.getConnection();
	}

	/**
	 * Method to add advertisement
	 * 
	 * @param advertisement
	 *            object of {@link Advertisement}
	 * @return true if added successfully
	 * @throws SQLException
	 */
	public boolean addAdvertisement(Advertisement advertisement)
			throws SQLException {
		PreparedStatement stmt = conn
				.prepareStatement(AdvertisementQuery.INSERT_ADVERTISMENT);
		stmt.setString(1, advertisement.getAdvTitle());
		stmt.setString(2, advertisement.getAdvDesc());
		stmt.setInt(3, advertisement.getCategoryId());
		return 1 == stmt.executeUpdate();
	}

	/**
	 * method to retrieve advertisement by category
	 * 
	 * @param id
	 *            is id of category
	 * @return list of {@link Category}
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public List<Category> getAdvertisementByCategory(int id)
			throws SQLException, ClassNotFoundException {
		List<Advertisement> advertisementList = new ArrayList<>();
		List<Category> finalCategory = new ArrayList<>();
		PreparedStatement stmt = conn
				.prepareStatement(AdvertisementQuery.SELECT_ADVERTISMENT_BY_CATEGORY);
		stmt.setInt(1, id);
		ResultSet rSet = stmt.executeQuery();
		while (rSet.next()) {
			Advertisement advertisement = new Advertisement();
			advertisement.setAdvId(rSet.getInt("advId"));
			advertisement.setAdvTitle(rSet.getString("advTitle"));
			advertisement.setAdvDesc(rSet.getString("advDesc"));
			advertisementList.add(advertisement);
		}
		List<Category> cat = new CategoryDao().getCategory(id);
		Category finalResult = new Category();
		finalResult.setCategoryId(cat.get(0).getCategoryId());
		finalResult.setCategoryName(cat.get(0).getCategoryName());
		finalResult.setAdvList(advertisementList);
		finalCategory.add(finalResult);
		return finalCategory;
	}

	/**
	 * Method to retrieve all the categories
	 * 
	 * @return list of {@link Category}
	 * @throws SQLException
	 */
	public List<Category> getAll() throws SQLException {
		List<Advertisement> advertisementList = new LinkedList<>();
		List<Category> finalList = new ArrayList<>();
		PreparedStatement stmt = conn
				.prepareStatement(AdvertisementQuery.SELECT_ALL_ADVERTISMENT);
		ResultSet rSet = stmt.executeQuery();
		while (rSet.next()) {
			Advertisement advertisement = new Advertisement();
			advertisement.setAdvId(rSet.getInt("advId"));
			advertisement.setAdvTitle(rSet.getString("advTitle"));
			advertisement.setAdvDesc(rSet.getString("advDesc"));
			advertisementList.add(advertisement);
		}
		Category cat = new Category();
		cat.setAdvList(advertisementList);
		finalList.add(cat);
		return finalList;
	}

	/**
	 * method to update advertisement title
	 * 
	 * @param id
	 *            of advertisement
	 * @param title
	 *            of advertisement
	 * @return true when update successfully
	 * @throws SQLException
	 */
	public boolean setTitle(int id, String title) throws SQLException {
		PreparedStatement stmt = conn
				.prepareStatement(AdvertisementQuery.UPDATE_ADVERTISMENT);
		stmt.setString(1, title);
		stmt.setInt(2, id);
		return 1 == stmt.executeUpdate();
	}

	/**
	 * method to delete advertisement by advertisement id
	 * 
	 * @param id
	 *            of advertisement
	 * @return true if added successfully
	 * @throws SQLException
	 */
	public boolean remove(int id) throws SQLException {
		PreparedStatement stmt = conn
				.prepareStatement(AdvertisementQuery.DELETE_ADVERTISMENT);
		stmt.setInt(1, id);
		return 1 == stmt.executeUpdate();
	}

}
