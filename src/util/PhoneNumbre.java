package util;

import java.util.HashMap;
import java.util.Map;

public class PhoneNumbre {
   private Country country;
   private String number;
public Country getCountry() {
	return country;
}
public void setCountry(Country country) {
	this.country = country;
}
public String getNumber() {
	return number;
}
public void setNumber(String number) {
	this.number = number;
}

public PhoneNumbre(Country country, String number) throws NumberFormatException {
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
	/*
	Map<Country, String> num = new HashMap<Country, String>();
	num.putIfAbsent(Country.Maroc, "+212");
	num.putIfAbsent(Country.France, "+33");
	num.putIfAbsent(Country.CoteIvoire, "+211");
	return num.get(country) + "-"+ number;
	*/
	return number;
}
   
}
