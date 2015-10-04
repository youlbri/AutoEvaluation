package creation_compte_connection;

import java.util.ArrayList;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import util.MailAddress;
import util.Password;
import util.PhoneNumbre;

import accesDonnees.interfaceDB;
import creation_tache_objectif.Objectif;
import creation_tache_objectif.Tache;

public class User {

	private String name;
	private String familyName;
	private PhoneNumbre number;
	private MailAddress mail;
	private Password motPass;
	SimpleDateFormat frm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String currentTime = frm.format(new Date());
	
	// TODO for now we will use this database, but later the administrator will
	// can change the arguments.
	String sql;
	interfaceDB con = new interfaceDB("Base_utilisateur", "root", "Fifa2006");


	private int isConnected = -1;
	private static final int CONNECTION_SUCCESS = 1;

	public User(String name, String familyName, PhoneNumbre phoneNum, MailAddress mail, Password motPass) {
		super();
		this.name = name;
		this.familyName = familyName;
		this.number = phoneNum;
		this.mail = mail;
		this.motPass = motPass;
	}

	public boolean save() {
		// This function save the user in the Table User in the DataBase.
		
		String sql = "insert base_utilisateur.utilisateur (numero_telephone, prenom, nom, adresse_mail, mot_pass) values ('"
				+ number.toString() + "','" + name + "','" + familyName.toUpperCase() + "','" + mail.toString()
				+ "','" + motPass.getPassword() + "');";		
		return con.modifierDonnees(sql);
	}

	public int connect() throws SQLException {
		/*
		 * return: positive value if The user and password are corrects, it
		 * return 0 if the user or password are wrong or if the user is not in
		 * the database, and it return negative value if the connection to the
		 * database failed
		 * 
		 */
		ResultSet rs = null;
		String pass = null;
			sql = "select mot_pass from base_utilisateur.utilisateur where adresse_mail='" + this.mail.toString()
					+ "';";
			ArrayList<String> fields = new ArrayList<String>();
			fields.add("mot_pass");
			rs = con.chercher("utilisateur", fields, "adresse_mail", this.getMail());
			while(rs.next()){
				pass = rs.getString("mot_pass");
			}
			if (pass.compareTo(this.motPass.getPassword()) == 0) {
				isConnected = 1;
			} else {
				isConnected = 0;
			}
		return isConnected;

	}

	public boolean nouvelObjectifOuTache(Object objectifOuTache) throws SQLException {
		boolean res = false;
		if (isConnected == CONNECTION_SUCCESS)
		{
			if (objectifOuTache instanceof Objectif){
				res = ((Objectif) objectifOuTache).save();
				String id_objectif = ((Objectif) objectifOuTache).getField("id_objectfs");
				sql = "insert into base_utilisateur.objectifs_du_mois_has_utilisateur (Objectifs_du_mois_id_objectifs, Utilisateur_id_utilisateur) values ('"+ id_objectif +"','" +this.getField("id_utilisateur")+"')";
				
			}
			else{
				res = ((Tache) objectifOuTache).save();
				String id_tache = ((Tache) objectifOuTache).getField("id_tache");
				System.out.println(id_tache);
				sql = "insert into base_utilisateur.executer (date_modification, Taches_id_tache, Utilisateur_id_utilisateur) values ('"+ currentTime +"','"+ id_tache+"','"+this.getField("id_utilisateur")+"');";
			
	}
			con.modifierDonnees(sql);
			
		}
		return res;
	}

	public String getField(String field) {
		// TODO Auto-generated method stub
		String res = null;
		ArrayList<String> fields = new ArrayList<String>();
		fields.add(field);
		ResultSet rs = con.chercherText("utilisateur", fields , "adresse_mail", "\"" + this.mail.toString() + "\"");
		try {
			while(rs.next()){
				res = rs.getString(field);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

	// The Getters and Setters:
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

	public String getMail() {
		return mail.toString();
	}

	public void setMail(MailAddress mail) {
		this.mail = mail;
	}
	@Override
	public String toString() {
		return "User: " + name + " " + familyName + " \n Phone= " + number.toString() + "\n mail= " + mail.toString();
	}
	public void tacheAccomplie(Tache tache){
		tache.setAccomplie(true);
	}

	public void tache_nn_accomplie(Tache tache, String raison_nn_execution){
		tache.setRaison_nn_execution(raison_nn_execution);
		tache.setAccomplie(false);
	}
}