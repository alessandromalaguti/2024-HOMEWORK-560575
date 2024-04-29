package it.uniroma3.diadia.ambienti;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;

public class LabirintoTest {
	Labirinto labirinto;
	Stanza atrio;
	Stanza N11;

	@Before
	public void setUp() {
		labirinto = new Labirinto();
		labirinto.creaStanze();
		atrio = new Stanza("atrio");
		N11 = new Stanza("N11");
	}


	@Test
	public void testGetStanzaVincente() {
		assertEquals("Biblioteca", labirinto.getStanzaFinale().getNome());
	}


	@Test
	public void testSetStanzaCorrente() {
		labirinto.setStanzaIniziale(N11);
		assertEquals(N11, labirinto.getStanzaIniziale());
	}
	@Test
	public void testGetStanzaCorrente() {
		assertEquals("Atrio", labirinto.getStanzaIniziale().getNome());
	}

}
