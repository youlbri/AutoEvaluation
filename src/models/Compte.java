package models;

import util.MailAddress;
import util.Password;

public class Compte {
	private MailAddress mail;
	private Password motPass;
	
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
}
