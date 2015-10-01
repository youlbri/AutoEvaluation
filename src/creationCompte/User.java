package creationCompte;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import util.MailAddress;
import util.Password;
import util.PhoneNumbre;

import accesDonnees.interfaceDB;

public class User {

	private String name;
	private String familyName;
	private PhoneNumbre number;
	private MailAddress mail;
	private Password motPass;

	public User(String name, String familyName, PhoneNumbre phoneNum, MailAddress mail, Password motPass) {
		super();
		this.name = name;
		this.familyName = familyName;
		this.number = phoneNum;
		this.mail = mail;
		this.motPass = motPass;
	}

	
	
	public boolean save(){
		// This function save the user in the Table User in the DataBase.
		boolean res = true;
		try {
		// Connect to the data base:
		interfaceDB con = new interfaceDB("Base_utilisateur", "root", "Fifa2006");
		Statement  dv = con.connect();
		// saving the user in the table User:
		String sql = "insert base_utilisateur.utilisateur (numero_telephone, prenom, nom, adresse_mail, mot_pass) values ('"+number.toString()+"','"+name+"','"+familyName.toUpperCase()+"','"+mail.toString()+"','"+motPass.getPassword()+"');";
		dv.executeUpdate(sql);
		}
		catch (ClassNotFoundException | SQLException exp){
			exp.printStackTrace();
			res = false;
		}
		return res;
	}
	
	public int connect(){
		/*
		 * return: positive value if The user and password are corrects, 
		 * it return 0 if the user or password are wrong or if the user is not in the database, 
		 * and  it return negative value if the connection to the database failed 
		 * 
		 */
		int res = -1;
		interfaceDB con = new interfaceDB("Base_utilisateur", "root", "Fifa2006");
		ResultSet rs = null;
		String pass = null;
		try {
			Statement  dv = con.connect();
			String sql = "select mot_pass from base_utilisateur.utilisateur where numero_telephone='"+this.number+"';";
			rs = dv.executeQuery(sql);
			
			while(rs.next()){
				pass = rs.getString("mot_pass");
			}
			if (pass.compareTo(this.motPass.getPassword()) == 0) {
				res = 1;
			}
			else{
				res = 0;
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
		
	}
	
	
	//The Getters and Setters:
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public PhoneNumbre getPhoneNum() {
		return number;
	}

	public void setPhoneNum(PhoneNumbre phoneNum) {
		this.number = phoneNum;
	}

	public MailAddress getMail() {
		return mail;
	}

	public void setMail(MailAddress mail) {
		this.mail = mail;
	}

	public Password getMotPass() {
		return motPass;
	}

	public void setMotPass(Password motPass) {
		this.motPass = motPass;
	}

	@Override
	public String toString() {
		return "User: " + name + " " + familyName + " \n Phone= " + number.toString() + "\n mail= " + mail.toString();
	}

}