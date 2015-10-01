package presentation;

import java.sql.SQLException;

import accesDonnees.interfaceDB;
import creationCompte.User;
import util.Country;
import util.MailAddress;
import util.Password;
import util.PhoneNumbre;

public class Principale {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		User moi = new User("saad", "boudfor", new PhoneNumbre(Country.France, "07-51-64-22-65"), new MailAddress("sboudfor","gmail"), new Password("fifa2006"));
		//moi.save();
		System.out.println(moi.connect());

   }
}