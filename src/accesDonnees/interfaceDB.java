package accesDonnees;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

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
	
	public Statement connect() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		 Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+database, user, password);
		 return cn.createStatement();
	}
	
}
