
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestGetAll {
	public static void main(String[] args) throws SQLException {
		String url = "jdbc:mysql://localhost:3306/javabatch";
		String username = "root";
		String password = "root";
		Connection connection = null;
		String sql = "select * from student";
		try {
			// load register the driver m]
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Establish the connection

			connection = DriverManager.getConnection(url, username, password);
			// Create statement

			Statement statement = connection.createStatement();

			// Execute the statemnt

			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
			}
			// close the connection
			connection.close();
			System.out.println("All good");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				connection.close();
				System.out.println("close");
			}
		}
	}
}
