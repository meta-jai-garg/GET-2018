package com.meta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.meta.model.Category;
import com.meta.util.DbUtil;

public class CategoryDao {
	private Connection conn;

	public CategoryDao() throws ClassNotFoundException, SQLException {
		conn = DbUtil.getConnection();
	}

	/**
	 * method to add category
	 * 
	 * @param category
	 * @throws SQLException
	 */
	public void add(Category category) throws SQLException {
		PreparedStatement stmt = conn
				.prepareStatement(CategoryQuery.INSERT_CATEGORY);
		stmt.setString(1, category.getCategoryName());
		stmt.executeUpdate();
	}

	/**
	 * method to retrieve category by id
	 * 
	 * @param id
	 *            of category
	 * @return
	 * @throws SQLException
	 */
	public List<Category> getCategory(int id) throws SQLException {
		List<Category> list = new ArrayList<Category>();
		PreparedStatement stmt = conn
				.prepareStatement(CategoryQuery.SELECT_CATEGORY);
		stmt.setInt(1, id);
		ResultSet rSet = stmt.executeQuery();
		if (rSet.next()) {
			Category category = new Category();
			category.setCategoryId(rSet.getInt("categoryId"));
			category.setCategoryName(rSet.getString("categoryName"));
			list.add(category);
		}
		return list;
	}

	/**
	 * method to retrieve all categories
	 * 
	 * @return list of {@link Category}
	 * @throws SQLException
	 */
	public List<Category> getCategory() throws SQLException {
		List<Category> list = new ArrayList<>();
		PreparedStatement stmt = conn
				.prepareStatement(CategoryQuery.SELECT_ALL_CATEGORY);
		ResultSet rSet = stmt.executeQuery();
		while (rSet.next()) {
			Category category = new Category();
			category.setCategoryId(rSet.getInt("categoryId"));
			category.setCategoryName(rSet.getString("categoryName"));
			list.add(category);
		}
		return list;
	}

	/**
	 * method to update category name
	 * 
	 * @param id
	 *            of {@link Category}
	 * @param name
	 *            of {@link Category}
	 * @return true when updated successfully
	 * @throws SQLException
	 */
	public boolean updateName(int id, String name) throws SQLException {
		PreparedStatement stmt = conn
				.prepareStatement(CategoryQuery.UPDATE_CATEGORY);
		stmt.setString(1, name);
		stmt.setInt(2, id);
		return 1 == stmt.executeUpdate();
	}
	
}
