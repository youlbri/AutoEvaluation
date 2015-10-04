package creation_tache_objectif;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import accesDonnees.interfaceDB;

public class Objectif {
	private short num;
	private String objectif;
	private String categorie;
	private boolean type;
	private short taux_accompliessement = 100;
	String sql;
	interfaceDB con = new interfaceDB("Base_utilisateur", "root", "Fifa2006");
	public short getNum() {
		return num;
	}

	public void setNum(short num) {
		this.num = num;
	}

	public String getObjectif() {
		return objectif;
	}

	public void setObjectif(String objectif) {
		this.objectif = objectif;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public boolean isType() {
		return type;
	}

	public void setType(boolean type) {
		this.type = type;
	}


	public Objectif(String objectif, String categorie, short num, boolean type){
		this.objectif = objectif;
		this.categorie = categorie;
		this.num = num;
		this.type = type;
	}
	
	public Objectif(String objectif, short num, boolean type){
		this.objectif = objectif;
		this.num = num;
		this.type = type;
	}

	public boolean creerTache(Tache tache, short taux_accompliessement){
		 tache.setTaux_accomplissement(taux_accompliessement);	
		 return save();
		 
		 
	}
	
	public boolean creerObjectif(Objectif objectifSemaine, short taux_accompliessement){
		objectifSemaine.setTaux_accompliessement(taux_accompliessement);
		objectifSemaine.setCategorie(categorie);
		return objectifSemaine.save();
	}

	public short getTaux_accompliessement() {
		return taux_accompliessement;
	}

	public void setTaux_accompliessement(short taux_accompliessement) {
		this.taux_accompliessement = taux_accompliessement;
	}
	
	public boolean save(){
		boolean res = false;
		// TODO to implement
		sql = "insert into base_utilisateur.objectifs_du_mois (objectif,categorie,mois) values ('"+ this.objectif +"','"+ this.categorie +"','"+ this.num+"')";
		con.modifierDonnees(sql);
		return res;
	}
	
	public String getField(String field){
		String res = null;
		String fieldDB = "objectif";
		ArrayList<String> fields = new ArrayList<String>();
		fields.add(field);
		ResultSet rs = con.chercherText("objectifs_du_mois", fields , fieldDB, this.objectif);
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
		
	

}
