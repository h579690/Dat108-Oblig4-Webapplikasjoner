package no.hvl.dat108.hjelpeklasser;

public class Validation {
	
	public boolean erGyldigNavn(String navn) {
		if(!navn.isBlank()
				&&navn.substring(0,1).matches("[A-ZÆØÅ]+") 
				&& navn.matches("^([A-ZÆØÅ][\\-\\sa-zA-ZæøåÆØÅ]+)")
				&& (navn.length() > 1 && navn.length() < 21)) {
			return true;
		}
			
		return false;	
	}
	
	public boolean erGyldigMobil(String mobil) {
		if(mobil.length() == 8 
				&& mobil.matches("[0-9]+")
				&& !mobil.isBlank()) {
			return true;
		}
		
		return false;
	}

	public boolean erGyldigPassord(String passord) {
		if(passord.length() > 3 
				&& !passord.isBlank()) {
			return true;
		}
		
		return false;
	}
	public boolean erGyldigPassordRepetert(String passord, String passordRepetert) {
		if(passord.contentEquals(passordRepetert)) {
			return true;
		}
		
		return false;
	}
	
	public boolean erGyldigKjonn(String kjonn) {
		if(!kjonn.equals("mann") && !kjonn.equals("kvinne")) {
			return false;
		}
		return true;
	}
	
	public String escapeHtml(String s) {
		String resultat = s;
		resultat = resultat.replaceAll("<", "&lt;");
		resultat = resultat.replaceAll(">", "&gt;");
		resultat = resultat.replaceAll("\"", "&quot;");
		return resultat;
	}
}
