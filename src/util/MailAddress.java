package util;

public class MailAddress {
	private String addressServeur;
	private String identifiant;
	private String domaine;

	public String getAddressServeur() {
		return addressServeur;
	}

		
	public MailAddress(String identifiant, String addressServeur, String domaine) {
		super();
		this.addressServeur = addressServeur;
		this.identifiant = identifiant;
		this.domaine = domaine;
	}

	public MailAddress(String identifiant, String addressServeur) {
		super();
		this.addressServeur = addressServeur;
		this.identifiant = identifiant;
		this.domaine = "com";
	}
	@Override
	public String toString() {
		return this.identifiant +"@" +this.addressServeur + "."+this.domaine ;
	}

	public void setAddressServeur(String addressServeur) {
		this.addressServeur = addressServeur;
	}

	public String getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public String getDomaine() {
		return domaine;
	}

	public void setDomaine(String domaine) {
		this.domaine = domaine;
	}

}
