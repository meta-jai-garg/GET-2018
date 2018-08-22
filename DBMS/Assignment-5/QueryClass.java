import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QueryClass {
	/**
	 * method to find orders correspond to given user id
	 * 
	 * @param userId
	 *            is id of user
	 * @return list of orders placed by given user
	 * @throws SQLException
	 */
	public List<OrderPojo> orderByUserID(int userId) {
		if (userId < 0) {
			System.out.println("Invalid input !!!");
			System.exit(0);
		}
		
		List<OrderPojo> orderPojo = new ArrayList<OrderPojo>();
		final String querySelect = "select\r\n"
				+ "pod.order_id,\r\n"
				+ "po.order_date,\r\n"
				+ "SUM(pod.amount*pod.quantity) AS 'amount'\r\n"
				+ "FROM\r\n"
				+ "product p\r\n"
				+ "INNER JOIN\r\n"
				+ "product_order_detail pod ON p.product_id = pod.product_id\r\n"
				+ "INNER JOIN\r\n"
				+ "product_order po ON po.order_id = pod.order_id\r\n"
				+ "WHERE\r\n" + "pod.status = 'SHIPPED' AND po.user_id = ?\r\n"
				+ "GROUP BY (pod.order_id)\r\n"
				+ "ORDER BY (po.order_date) DESC";
		
		try (Connection conn = JDBCConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(querySelect);) {
			stmt.setInt(1, userId);
			ResultSet rSet = stmt.executeQuery();
			while (rSet.next()) {
				OrderPojo pojo = new OrderPojo();
				pojo.setOrderId(rSet.getInt("order_id"));
				pojo.setOrderDate(rSet.getDate("order_date"));
				pojo.setAmount(rSet.getDouble("amount"));
				orderPojo.add(pojo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(3);
		}
		return orderPojo;
	}

	/**
	 * Method to insert image for a product in a batch
	 * 
	 * @throws SQLException, BatchUpdateException
	 */
	public int imageBatchInsert() {
		int[] totalInsertion = {};
		final String queryInsert = "INSERT INTO product_image(img_url, img_name, product_id)VALUES(?,?,?)";
		try (Connection conn = JDBCConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(queryInsert)) {
			try {
				conn.setAutoCommit(false);
				for (int index = 1; index <= 5; index++) {
					stmt.setString(1, "img_url" + index);
					stmt.setString(2, "img_name" + index);
					stmt.setInt(3, 11);
					stmt.addBatch();
				}
				totalInsertion = stmt.executeBatch();
				conn.commit();
			} catch (BatchUpdateException batch) {
				System.out.println("Invalid!!!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(3);
		}
		return totalInsertion.length;
	}

	/**
	 * Method to update product state which were not ordered in last 1 year
	 * 
	 * @return no of products that are updated.
	 * @throws SQLException
	 */
	public int updateProductState() {
		int affectedRows = 0;
		final String queryUpdate = "UPDATE product\r\n"
				+ "SET active = 0\r\n"
				+ "WHERE product.product_id\r\n"
				+ "NOT IN(\r\n"
				+ "SELECT DISTINCT(od.product_id) \r\n"
				+ "FROM product_order_detail od INNER JOIN product_order po ON po.order_id = od.order_id\r\n"
				+ "WHERE DATEDIFF(NOW(), po.order_date) <= 365\r\n"
				+ ") AND active=1";
		try (Connection conn = JDBCConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(queryUpdate);) {
			affectedRows = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(3);
		}
		return affectedRows;
	}

	/**
	 * Method to find top categories and count of their child categories.
	 * 
	 * @return List of {@code CategoryPojo} sorted alphabetically
	 * 
	 * @throws SQLException
	 */
	public List<CategoryPojo> categoryTitle() {
		List<CategoryPojo> categoryPojo = new ArrayList<CategoryPojo>();
		final String querySelect = "SELECT \r\n"
				+ "a.category_name AS 'Top_Category',\r\n"
				+ "COUNT(b.category_name) AS 'Category_Count'\r\n" + "FROM\r\n"
				+ "category a\r\n" + "INNER JOIN\r\n"
				+ "category b ON a.category_id = b.parent_category\r\n"
				+ "GROUP BY (a.category_name)\r\n" + "ORDER BY a.category_name";
		try (Connection conn = JDBCConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(querySelect);) {
			ResultSet rSet = stmt.executeQuery();
			while (rSet.next()) {
				CategoryPojo pojo = new CategoryPojo();
				pojo.setTopCategory(rSet.getString("Top_Category"));
				pojo.setChildCategoryCount(rSet.getInt("Category_Count"));
				categoryPojo.add(pojo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(3);
		}
		return categoryPojo;
	}
}
