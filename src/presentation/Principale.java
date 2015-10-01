package presentation;

import java.sql.SQLException;

import creation_compte_connection.User;
import util.Country;
import util.MailAddress;
import util.Password;
import util.PhoneNumbre;

public class Principale {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		User moi = new User("saad", "boudfor", new PhoneNumbre(Country.France, "06-18-22-02-25"), new MailAddress("saad.boudfor","gmail"), new Password("fifa2006"));
		moi.save();
		System.out.println(moi.connect());

   }
}