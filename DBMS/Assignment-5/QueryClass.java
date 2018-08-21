import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QueryClass {
	public List<OrderPojo> orderByUserID(int userId) {
		if (userId < 0) {
			System.out.println("Invalid input !!!");
			System.exit(0);
		}
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
		List<OrderPojo> orderPojo = new ArrayList<OrderPojo>();
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

	public void imageBatchInsert() {
		final String queryInsert = "INSERT INTO product_image(img_url, img_name, product_id)VALUES(?,?,?)";
		try (Connection conn = JDBCConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(queryInsert)) {
			try {
				conn.setAutoCommit(false);
				for (int index = 1; index <= 5; index++) {
					stmt.setString(1, "img_url" + index);
					stmt.setString(2, "img_name" + index);
					stmt.setInt(3, 22);
					stmt.addBatch();
				}
				int[] totalInsertion = stmt.executeBatch();
				System.out.println(totalInsertion.length);
				conn.commit();
			} catch (BatchUpdateException batch) {
				System.out.println("Invalid!!!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(3);
		}
	}
	
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

	public List<CategoryPojo> categoryTitle() {
		List<CategoryPojo> categoryPojo = new ArrayList<CategoryPojo>();
		final String querySelect = "SELECT \r\n"
				+ "a.category_name AS 'Top_Category',\r\n"
				+ "COUNT(b.category_name) AS 'Category_Count'\r\n" + "FROM\r\n"
				+ "category a\r\n" + "INNER JOIN\r\n"
				+ "category b ON a.category_id = b.parent_category\r\n"
				+ "GROUP BY (a.category_name)\r\n"
				+ "ORDER BY a.category_name,b.category_name;";
		try (Connection conn = JDBCConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(querySelect);) {
			ResultSet rSet = stmt.executeQuery();
			while (rSet.next()) {
				CategoryPojo pojo = new CategoryPojo();
				pojo.setTopCategory(rSet.getString("Top_Category"));
				pojo.setChildCategoryCount(rSet.getInt("Category_Count"));
				categoryPojo.add(pojo);
			}
			System.out.println(categoryPojo.toString());
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(3);
		}
		return categoryPojo;
	}

	public static void main(String[] args) {
		System.out.println(new QueryClass().updateProductState());
	}
}