package com.meta.dao;

public interface CategoryQuery {
	String INSERT_CATEGORY = "INSERT INTO category (categoryName) VALUES (?)";
	String SELECT_CATEGORY = "SELECT categoryId, categoryName FROM category WHERE categoryId = ?";
	String SELECT_ALL_CATEGORY = "SELECT categoryId, categoryName FROM category";
	String UPDATE_CATEGORY = "UPDATE category SET categoryName = ? WHERE categoryId = ?";
	String DELETE_CATEGORY = "DELETE FROM category WHERE categoryId = ?";
}
