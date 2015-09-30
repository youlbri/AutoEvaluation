package accesDonnees;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;

public class interfaceDB {
	// Here the user and the password are those used to access to database.
	private String user;
	private String password;
	private String database;
	
	public interfaceDB(String database, String user, String password) {
		super();
		this.user = user;
		this.password = password;
		this.database = database;
	}
	
	public Connection connect() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/"+database, user, password);
	}
	
}
