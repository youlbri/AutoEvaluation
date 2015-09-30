package creationCompte;

import java.sql.Connection;
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

	
	
	public boolean save() throws ClassNotFoundException, SQLException{
		// This function save the user in the Table User in the DataBase.
		boolean res = true;
		// Connect to the data base:
		interfaceDB con = new interfaceDB("Base_utilisateur", "root", "Fifa2006");
		Connection cn = con.connect();
		Statement  dv = cn.createStatement();
		// saving the user in the table User:
		String sql = "insert base_utilisateur.utilisateur (numero_telephone, prenom, nom, adresse_mail, mot_pass) values ('"+number.toString()+"','"+name+"','"+familyName.toUpperCase()+"','"+mail.toString()+"','"+motPass.getPassword()+"');";
		System.out.println(sql);
		dv.executeUpdate(sql);
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