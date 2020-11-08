package no.hvl.dat108.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import no.hvl.dat108.hjelpeklasser.Validation;


public class ValidatorTest {
	private Validation validation = new Validation();
	

	@Test
	public void ValidNavn() {
		assertFalse(validation.erGyldigNavn(""));
		assertTrue(validation.erGyldigNavn("Anne"));
		assertFalse(validation.erGyldigNavn("anne"));
		assertTrue(validation.erGyldigNavn("Anne-Grete"));
		assertTrue(validation.erGyldigNavn("Anne Grete"));
		assertFalse(validation.erGyldigNavn("Anne?Grete"));
		
		assertTrue(validation.erGyldigNavn("ÆØÅ"));
	}
	
	
	@Test
	public void ValidMobil() {
		assertFalse(validation.erGyldigMobil(""));
		assertTrue(validation.erGyldigMobil("12345678"));
		assertFalse(validation.erGyldigMobil("1234ab78"));
		assertFalse(validation.erGyldigMobil("1234567"));
		assertFalse(validation.erGyldigMobil("123456789")); 
	}
	
	
	@Test
	public void ValidPassord() {
		assertFalse(validation.erGyldigPassord(""));
		assertTrue(validation.erGyldigPassord("1234"));
		assertTrue(validation.erGyldigPassord("abcd"));
		assertTrue(validation.erGyldigPassord("a!?@"));
	}
	
	
	@Test 
	public void ValidRepeterPassord() {
		assertTrue(validation.erGyldigPassordRepetert("123abc", "123abc"));
		assertFalse(validation.erGyldigPassordRepetert("123abc", "1233bc"));
	}
	
	
	@Test
	public void ValidKjonn() {
		assertFalse(validation.erGyldigKjonn(""));
		assertTrue(validation.erGyldigKjonn("kvinne"));
		assertTrue(validation.erGyldigKjonn("mann"));
	}
}

