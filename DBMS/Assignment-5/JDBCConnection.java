import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class JDBCConnection {
	private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_NAME = "storefront";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/"+DB_NAME;
	private static final String DB_USERNAME = "root";
	private static final String DB_PASSWORD = "12345";
	 public static Connection getConnection(){
		 Connection conn = null;
		 try {
			Class.forName(DB_DRIVER);
			conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(2);
		}
		 return conn;
	 }
}