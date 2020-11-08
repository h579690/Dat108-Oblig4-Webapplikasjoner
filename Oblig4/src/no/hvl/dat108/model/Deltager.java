package no.hvl.dat108.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema ="DAT108_Oblig4", name="deltager")
public class Deltager {

	@Id
	private String mobil;
	
	private String fornavn;
	private String etternavn;
	private String passordhash;
	private char kjonn;
	
	
	public Deltager(String mobil, String fornavn, String etternavn, String passordhash, char kjonn) {
		this.mobil = mobil;
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.passordhash = passordhash;
		this.kjonn = kjonn;
	}
	
	public Deltager() {}

	public String getMobil() {
		return mobil;
	}

	public String getFornavn() {
		return fornavn;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public String getPassordhash() {
		return passordhash;
	}
	
	public char getKjonn() {
		return kjonn;
	}
	
	
	public String getTegn() {
		if(kjonn == 'M') {
			return "&#9794;";
		} else {
			return "&#9792;";
		}
	}

	
	@Override
	public String toString() {
		return "Deltager [mobil=" + mobil + ", fornavn=" + fornavn + ", etternavn=" + etternavn + ", passordhash="
				+ passordhash +  ", kjonn=" + kjonn + "]";
	}
	
	
}
