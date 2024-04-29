package it.uniroma3.diadia.giocatore;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class BorsaTest {

	Borsa borsa = new Borsa();
	Attrezzo cacciavite;
	Attrezzo martello;
	
	@Before
	public void setUp() {
		cacciavite = new Attrezzo("cacciavite", 2);
		martello = new Attrezzo("martello", 16);
	}

	@Test
	public void testAddAttrezzoPesoMinoreDiDieci() {
		assertTrue(borsa.addAttrezzo(cacciavite));

	}
	
	@Test
	public void testAddAttrezzoPesoMaggioreDiDieci() {
		assertFalse(borsa.addAttrezzo(martello));

	}
	
	@Test
	public void testGetPeso() {
		borsa.addAttrezzo(cacciavite);
		assertEquals(cacciavite, borsa.getAttrezzo("cacciavite"));

	}
}