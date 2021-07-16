package JDBCUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionJDBC{
	
	public static Connection getConexao() throws SQLException, ClassNotFoundException{
		
		Connection conexao = null;
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "BDJDBC";
		String password = "bdjdbc";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conexao = DriverManager.getConnection(url, user, password);
			System.out.println("Registration done successfully!");
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return conexao;
	}

}
