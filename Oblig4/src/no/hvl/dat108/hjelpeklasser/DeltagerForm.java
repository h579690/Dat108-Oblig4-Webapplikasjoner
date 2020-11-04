package no.hvl.dat108.hjelpeklasser;

public class DeltagerForm {
	private String fornavn;
	private String etternavn;
	private String mobil;
	private String kjonn;
	
	private String fornavnMelding;
	private String etternavnMelding;
	private String mobilMelding;
	private String passordMelding;
	private String passordRepetertMelding;
	private String kjonnMelding;
	
	public DeltagerForm() {
		
		
	}
	
	public DeltagerForm(String fornavn, String etternavn, String mobil, String kjonn) {
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.mobil = mobil;
		this.kjonn = kjonn;
		
		fornavnMelding = "";
		etternavnMelding = "";
		mobilMelding ="";
		passordMelding = "";
		passordRepetertMelding  = "";
		kjonnMelding = "";
	}
	
	
	
	public void setFornavnMelding(String fornavnMelding) {
		this.fornavnMelding = fornavnMelding;
	}

	public void setEtternavnMelding(String etternavnMelding) {
		this.etternavnMelding = etternavnMelding;
	}

	public void setMobilMelding(String mobilMelding) {
		this.mobilMelding = mobilMelding;
	}

	public void setPassordMelding(String passordMelding) {
		this.passordMelding = passordMelding;
	}

	public void setPassordRepetertMelding(String passordRepetertMelding) {
		this.passordRepetertMelding = passordRepetertMelding;
	}

	public void setKjonnMelding(String kjonnMelding) {
		this.kjonnMelding = kjonnMelding;
	}

	public String getFornavnMelding() {
		return fornavnMelding;
	}


	public String getEtternavnMelding() {
		return etternavnMelding;
	}


	public String getMobilMelding() {
		return mobilMelding;
	}


	public String getPassordMelding() {
		return passordMelding;
	}

	public String getPassordRepetertMelding() {
		return passordRepetertMelding;
	}


	public String getKjonnMelding() {
		return kjonnMelding;
	}

	
	public String getFornavn() {
		return fornavn;
	}

	public void setFornavn(String fnavn) {
		this.fornavn = fnavn;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public void setEtternavn(String enavn) {
		this.etternavn = enavn;
	}

	public String getMobil() {
		return mobil;
	}

	public void setMobil(String mobil) {
		this.mobil = mobil;
	}

	public String getKjonn() {
		return kjonn;
	}

	public void setKjonn(String kjonn) {
		this.kjonn = kjonn;
	}
	
	

}
