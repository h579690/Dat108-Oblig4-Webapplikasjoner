package no.hvl.dat108;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestValidering {

	Validering validerInput = new Validering();
	Deltaker deltaker = new Deltaker("12345678", "passord", "Fornavn", "Etternavn", "m");

	@Test
	void testFornavn() {
		String n = "";
		boolean test = validerInput.testFornavn(n);
		assertFalse(test);	
		
		n = "Ab";
		test = validerInput.testFornavn(n);
		assertTrue(test);		
		
		n="A";
		test = validerInput.testFornavn(n);
		assertFalse(test);	
		
		n = "$dollar";
		test = validerInput.testFornavn(n);
		assertFalse(test);	
		
		n = "Abcdefabcdefabcdefabc";
		test = validerInput.testFornavn(n);
		assertFalse(test);
		
		n = "abc";
		test = validerInput.testFornavn(n);
		assertTrue(test);	
		
		n = "Kjetil";
		test = validerInput.testFornavn(n);
		assertTrue(test);	
		
		n = "Abcdefghijklmnopqrst";
		test = validerInput.testFornavn(n);
		assertTrue(test);	
	}
	
	@Test
	void testEtternavn() {
		String n = "";
		boolean test = validerInput.testEtternavn(n);
		assertFalse(test);	
		
		n = "Ab";
		test = validerInput.testEtternavn(n);
		assertTrue(test);		
		
		n="A";
		test = validerInput.testEtternavn(n);
		assertFalse(test);	
		
		n = "$dollar";
		test = validerInput.testEtternavn(n);
		assertFalse(test);	
		
		n = "Abcdefabcdefabcdefabc";
		test = validerInput.testEtternavn(n);
		assertFalse(test);
		
		n = "abc";
		test = validerInput.testEtternavn(n);
		assertTrue(test);	
		
		n = "Normann";
		test = validerInput.testEtternavn(n);
		assertTrue(test);	
		
		n = "Abcdefghijklmnopqrst";
		test = validerInput.testEtternavn(n);
		assertTrue(test);
	}
	
	@Test
	void testMobil() {
		
		String mobil = "99999999";
		boolean test = validerInput.testMobil(mobil);
		assertTrue(test);
		
		mobil = "999999999";
		test = validerInput.testMobil(mobil);
		assertFalse(test);
	
		mobil = "999999";
		test = validerInput.testMobil(mobil);
		assertFalse(test);
	
		mobil = "9191";
		test = validerInput.testMobil(mobil);
		assertFalse(test);
		
		mobil = "9";
		test = validerInput.testMobil(mobil);
		assertFalse(test);
		
		mobil = "";
		test = validerInput.testMobil(mobil);
		assertFalse(test);
	}
	
	@Test
	void testPassord() {
		String p = "1234Pass";
		boolean test = validerInput.testPassord(p);
		assertTrue(test);
		
		p = "Abcdefghijkl1234";
		test = validerInput.testPassord(p);
		assertTrue(test);
		
		p = "1234AbCdefghIj";
		test = validerInput.testPassord(p);
		assertTrue(test);
		
		p = "Pass123";
		test = validerInput.testPassord(p);
		assertFalse(test);
		
		p = "Abcdefghj123456789";
		test = validerInput.testPassord(p);
		assertFalse(test);
		
		p = "Pass";
		test = validerInput.testPassord(p);
		assertFalse(test);
		
		p = "12PASS";
		test = validerInput.testPassord(p);
		assertFalse(test);
		
		p = "123456";
		test = validerInput.testPassord(p);
		assertFalse(test);
	}
	
	@Test
	void testPassordRepeter() {
		
		String p1 = "Pass1234";
		String p2 = "Pass1234";
		boolean test = validerInput.testRepetert(p1, p2);
		assertTrue(test);
		
		p1 = "Pass123";
		p2 = "Pass1234";
		test = validerInput.testRepetert(p1, p2);
		assertFalse(test);
		
		p1 = "";
		p2 = "Pass1234";
		test = validerInput.testRepetert(p1, p2);
		assertFalse(test);
	}
}
