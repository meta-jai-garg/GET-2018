package com.meta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.meta.model.Advertisement;
import com.meta.util.DbUtil;

public class AdvertisementDao {
	private Connection conn;

	public AdvertisementDao() throws ClassNotFoundException, SQLException {
		conn = DbUtil.getConnection();
	}

	public void add(Advertisement advertisement) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement(AdvertisementQuery.INSERT_ADVERTISMENT);
		stmt.setString(1, advertisement.getAdvTitle());
		stmt.setString(2, advertisement.getAdvDesc());
		stmt.setInt(3, advertisement.getCategoryId());
		stmt.executeUpdate();
	}

	public Advertisement get(int id) throws SQLException {
		Advertisement advertisement = null;
		PreparedStatement stmt = conn.prepareStatement(AdvertisementQuery.SELECT_ADVERTISMENT);
		stmt.setInt(1, id);
		ResultSet rSet = stmt.executeQuery();
		if (rSet.next()) {
			advertisement = new Advertisement();
			advertisement.setCategoryId(rSet.getInt("categoryId"));
			advertisement.setAdvId(rSet.getInt("advId"));
			advertisement.setAdvTitle(rSet.getString("advTitle"));
			advertisement.setAdvDesc(rSet.getString("advDesc"));
		}
		return advertisement;
	}

	public List<Advertisement> getAll(int id) throws SQLException {
		List<Advertisement> advertisementList = new LinkedList<>();
		PreparedStatement stmt = conn.prepareStatement(AdvertisementQuery.SELECT_ADVERTISMENT_BY_CATEGORY);
		stmt.setInt(1, id);
		ResultSet rSet = stmt.executeQuery();
		while (rSet.next()) {
			Advertisement advertisement = new Advertisement();
			advertisement.setCategoryId(rSet.getInt("categoryId"));
			advertisement.setAdvId(rSet.getInt("advId"));
			advertisement.setAdvTitle(rSet.getString("advTitle"));
			advertisement.setAdvDesc(rSet.getString("advDesc"));
			advertisementList.add(advertisement);
		}
		return advertisementList;
	}

	public List<Advertisement> getAll() throws SQLException {
		List<Advertisement> advertisementList = new LinkedList<>();
		PreparedStatement stmt = conn.prepareStatement(AdvertisementQuery.SELECT_ALL_ADVERTISMENT);
		ResultSet rSet = stmt.executeQuery();
		while (rSet.next()) {
			Advertisement advertisement = new Advertisement();
			advertisement.setCategoryId(rSet.getInt("categoryId"));
			advertisement.setAdvId(rSet.getInt("advId"));
			advertisement.setAdvTitle(rSet.getString("advTitle"));
			advertisement.setAdvDesc(rSet.getString("advDesc"));
			advertisementList.add(advertisement);
		}
		return advertisementList;
	}

	public boolean setTitle(int id, String title) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement(AdvertisementQuery.UPDATE_ADVERTISMENT);
		stmt.setString(1, title);
		stmt.setInt(1, id);
		return 1 == stmt.executeUpdate();
	}

	public boolean remove(int id) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement(AdvertisementQuery.DELETE_ADVERTISMENT);
		stmt.setInt(1, id);
		return 1 == stmt.executeUpdate();
	}
}
