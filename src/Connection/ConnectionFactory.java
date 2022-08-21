package Connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	public ConnectionFactory() {}
	
	public Connection getConnection() {
		try {
			return DriverManager.getConnection("jdbc:mariadb://localhost:3306/aulajpa","root","");
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}                            
	}                                
}
