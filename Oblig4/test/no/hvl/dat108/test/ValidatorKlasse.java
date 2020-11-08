package no.hvl.dat108.test;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import no.hvl.dat108.hjelpeklasser.Validation;

public class ValidatorKlasse {
	private Validation validering = new Validation();

	@Test
	public void ValidNavn() {
		assertFalse(validering.erGyldigNavn(""));
		assertTrue(validering.erGyldigNavn("Anne"));
		assertFalse(validering.erGyldigNavn("anne"));
		assertTrue(validering.erGyldigNavn("Anne-Grete"));
		assertTrue(validering.erGyldigNavn("Anne Grete"));
		assertFalse(validering.erGyldigNavn("Anne?Grete"));
		
		assertTrue(validering.erGyldigNavn("ÆØÅ"));
	}
	
	
	@Test
	public void ValidMobil() {
		assertFalse(validering.erGyldigMobil(""));
		assertTrue(validering.erGyldigMobil("12345678"));
		assertFalse(validering.erGyldigMobil("1234ab78"));
		assertFalse(validering.erGyldigMobil("1234567"));
		assertFalse(validering.erGyldigMobil("123456789"));
	}
	
	
	@Test
	public void ValidPassord() {
		assertFalse(validering.erGyldigPassord(""));
		assertTrue(validering.erGyldigPassord("1234"));
		assertTrue(validering.erGyldigPassord("abcd"));
		assertTrue(validering.erGyldigPassord("a!?@"));
	}
	
	
	@Test 
	public void ValidRepeterPassord() {
		assertTrue(validering.erGyldigPassordRepetert("123abc", "123abc"));
		assertFalse(validering.erGyldigPassordRepetert("123abc", "1233bc"));
	}
	
	
	@Test
	public void ValidKjonn() {
		assertFalse(validering.erGyldigKjonn(""));
		assertTrue(validering.erGyldigKjonn("kvinne"));
		assertTrue(validering.erGyldigKjonn("mann"));
	}
}
