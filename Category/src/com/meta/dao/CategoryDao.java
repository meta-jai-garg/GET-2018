package com.meta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.meta.model.Category;
import com.meta.util.DbUtil;

public class CategoryDao {
	private Connection conn;

	public CategoryDao() throws ClassNotFoundException, SQLException {
		conn = DbUtil.getConnection();
	}

	public void add(Category category) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement(CategoryQuery.INSERT_CATEGORY);
		stmt.setString(1, category.getCategoryName());
		stmt.executeUpdate();
	}

	public Category get(int id) throws SQLException {
		Category category = null;
		PreparedStatement stmt = conn.prepareStatement(CategoryQuery.SELECT_CATEGORY);
		stmt.setInt(1, id);
		ResultSet rSet = stmt.executeQuery();
		if (rSet.next()) {
			category = new Category();
			category.setCategoryId(rSet.getInt("categoryId"));
			category.setCategoryName(rSet.getString("categoryName"));
		}
		return category;
	}

	public List<Category> getAll() throws SQLException {
		List<Category> categoryList = new LinkedList<>();
		PreparedStatement stmt = conn.prepareStatement(CategoryQuery.SELECT_ALL_CATEGORY);
		ResultSet rSet = stmt.executeQuery();
		while (rSet.next()) {
			Category category = new Category();
			category.setCategoryId(rSet.getInt("categoryId"));
			category.setCategoryName(rSet.getString("categoryName"));
			categoryList.add(category);
		}
		return categoryList;
	}

	public boolean setName(int id, String name) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement(CategoryQuery.UPDATE_CATEGORY);
		stmt.setString(1, name);
		stmt.setInt(2, id);
		return 1 == stmt.executeUpdate();
	}

	public boolean remove(int id) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement(CategoryQuery.DELETE_CATEGORY);
		stmt.setInt(1, id);
		return 1 == stmt.executeUpdate();
	}
}
