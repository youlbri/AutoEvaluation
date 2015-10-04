package creation_tache_objectif;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import accesDonnees.interfaceDB;

public class Tache {
	private String date;
	private short priorite;
	private String raison_nn_execution = " ";
	private short repetition=0;
	private String tache;
	private boolean accomplie;
	private short taux_accomplissement = 100;
    
	
	interfaceDB con = new interfaceDB("Base_utilisateur", "root", "Fifa2006");
	String sql;
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public short getPrioritee() {
		return priorite;
	}

	public void setPrioritee(short prioritee) {
		if (prioritee < 4)
		    this.priorite = prioritee;
	}

	public String getRaison_nn_execution() {
		return raison_nn_execution;
	}

	public void setRaison_nn_execution(String raison_nn_execution) {
		this.raison_nn_execution = raison_nn_execution;
	}

	public short getRepetition() {
		return repetition;
	}

	public void setRepetition(short repetition) {
		if (repetition < 3)
		    this.repetition = repetition;
	}

	public Tache(String tache, String str, short priorite, short repetition){
		this.setTache(tache);
		this.date = str;
		this.priorite = priorite;
		this.repetition = repetition;
	}

	public String getTache() {
		return tache;
	}

	public void setTache(String tache) {
		this.tache = tache;
	}
	
	public boolean isAccomplie() {
		return accomplie;
	}

	public void setAccomplie(boolean accomplie) {
		this.accomplie = accomplie;
	}

	public boolean save() {
		// TODO field raison can have null value.
		
		sql=" insert into base_utilisateur.taches (tache, date, priorite, repetition) values ('"+this.tache +"','"+this.date +"','"+this.priorite +"','"+ this.repetition+"');";
		con.modifierDonnees(sql);
		return false;
	}

	public short getTaux_accomplissement() {
		return taux_accomplissement;
	}

	public void setTaux_accomplissement(short taux_accomplissement) {
		this.taux_accomplissement = taux_accomplissement;
	}
	
	public String getField(String field) {
		// TODO Auto-generated method stub
		String res = null;
		String fieldDB = "tache";
		ArrayList<String> fields = new ArrayList<String>();
		fields.add(field);
		ResultSet rs = con.chercherText("taches", fields , fieldDB, "\""+ this.tache + "\"");
		try {
			while(rs.next()){
				// You should be careful to not trying looking for a field you did not display, because you will have a column not exist error.
				res = rs.getString(field);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

}
