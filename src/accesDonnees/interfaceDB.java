package accesDonnees;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class interfaceDB {
	// Here the user and the password are those used to access to database.
	private String user;
	private String password;
	private String database;
	Statement dv;
	Connection cn;
	private String sql;
	
	public interfaceDB(String database, String user, String password) {
		super();
		this.user = user;
		this.password = password;
		this.database = database;
	}
	
	
	public ResultSet lireDonnees(String sql) {
		ResultSet donnees = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + database, user, password);
			dv = cn.createStatement();
			donnees = dv.executeQuery(sql);
		
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    return donnees;
	}
	
	public ResultSet lireDonnees(String table, List<String> fields) {
		ResultSet donnees = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + database, user, password);
			dv = cn.createStatement();
			sql = "";
			for(String field: fields){
				sql+=field +",";
			}
			sql = "select (" + sql.subSequence(0, sql.length()-1) + ") from"+ this.database+ "."+table+";";
			
			donnees = dv.executeQuery(sql);
		
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    return donnees;
	}
	
	public ResultSet chercher(String table, List<String> fields, String type, String x){
		ResultSet donnees = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + database, user, password);
			dv = cn.createStatement();
			sql = "";
			for(String field: fields){
				sql+=field +",";
			}
			sql = "select (" + sql.subSequence(0, sql.length()-1) + ") from "+ this.database+ "."+table + " where "+ type +"='" + x +"';";
			System.out.println(sql);
			donnees = dv.executeQuery(sql);
		
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return donnees;	
	}
		
		public ResultSet chercherText(String table, List<String> fields, String type, String x){
			ResultSet donnees = null;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + database, user, password);
				dv = cn.createStatement();
				sql = "";
				for(String field: fields){
					sql+=field +",";
				}
				sql = "select (" + sql.subSequence(0, sql.length()-1) + ") from "+ this.database+ "."+table + " where "+ type +"=" + x +";";
				System.out.println(sql);
				donnees = dv.executeQuery(sql);
			
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


    return donnees;	
	}
	
	public boolean modifierDonnees(String sql){
		boolean res = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + database, user, password);
			dv = cn.createStatement();
			dv.executeUpdate(sql);
			res = true;
		
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	
	public boolean modifierDonnees(String table, List<String> fields, List<String> donnees){
		boolean res = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + database, user, password);
			dv = cn.createStatement();
			String fd = "";
			for(String field: fields){
				fd+=field +",";
			}
			String da = "";
			for(String donnee: donnees){
				da+= "'" +donnee +"',";
			}
			sql = "insert into "+ this.database+ "."+table+ "(" + fd.subSequence(0, sql.length()-1) + ") values (" + da.subSequence(0, sql.length()-1) +");";
			
			dv.executeUpdate(sql);
			res = true;
		
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

}
