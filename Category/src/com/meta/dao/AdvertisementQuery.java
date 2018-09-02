package com.meta.dao;

public interface AdvertisementQuery {
	String INSERT_ADVERTISMENT = "INSERT INTO advertisement (advTitle, advDesc, categoryId) VALUES (?,?,?)";
	String SELECT_ADVERTISMENT = "SELECT advId, advadvTitle, advDesc, categoryId FROM advertisement WHERE advId = ?";
	String SELECT_ADVERTISMENT_BY_CATEGORY = "SELECT advId, advTitle, advDesc, categoryId FROM advertisement WHERE categoryId = ?";
	String SELECT_ALL_ADVERTISMENT = "SELECT advId, advTitle, advDesc, categoryId FROM advertisement";
	String UPDATE_ADVERTISMENT = "UPDATE advertisement SET advTitle = ? WHERE advId = ?";
	String DELETE_ADVERTISMENT = "DELETE FROM advertisement WHERE advId = ?";
}
