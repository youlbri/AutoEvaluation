package util;

public class PhoneNumbre {
   private String country;
   private String number;
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}
public String getNumber() {
	return number;
}
public void setNumber(String number) {
	this.number = number;
}

public PhoneNumbre(String country, String number) throws NumberFormatException {
	super();
	this.country = country;
	int len = number.length();
	if  (len == 14) {
		for(int i = 0; i<number.length();i++ ){
			if (i%3 == 2){
				if (number.charAt(i) != '-'){
				     throw new NumberFormatException("Erreur de format: le nombre doit comporter 10 chiffre separes par des -");
				}
			}
		}
		this.number = number;
	}
	
}
@Override
public String toString() {
	return number;
}
   
}
