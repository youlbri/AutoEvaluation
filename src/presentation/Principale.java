package presentation;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import creation_compte_connection.User;
import creation_tache_objectif.Tache;
import util.Country;
import util.MailAddress;
import util.Password;
import util.PhoneNumbre;

public class Principale {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		SimpleDateFormat frm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String currentTime = frm.format(new Date());
		System.out.println(currentTime);
		User moi = new User("dosso", "fanga", new PhoneNumbre(Country.CoteIvoire, "05-89-55-15-48"), new MailAddress("ydosso","univ"), new Password("dosso1234"));
		//moi.save();
        System.out.println(moi.connect());
        moi.nouvelObjectifOuTache(new Tache("Trouver sol au problem B", currentTime, (short)1, (short)0));

   }
}