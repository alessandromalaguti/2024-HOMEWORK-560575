package it.uniroma3.diadia;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class PartitaTest {

	Partita partita = new Partita();
	
	Stanza stanza = new Stanza("Stanza");
	@Test
	public void testGetStanzaVincente() {
		assertEquals("Biblioteca", partita.getLabirinto().getStanzaFinale().getNome());
	}

	@Test
	public void testSetStanzaCorrente() {
		partita.getLabirinto().setStanzaIniziale(stanza);
		assertEquals(stanza, partita.getLabirinto().getStanzaIniziale());
		
	}

	
	@Test
	public void testIsFinita() {
		
		assertFalse(partita.isFinita());
		
		partita.getGiocatore().setCfu(0);
		assertEquals(true,partita.isFinita());
		
		partita.setFinita();
		assertEquals(true,partita.isFinita());
	}
	
	
}
