package it.uniroma3.diadia;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.ambienti.Stanza;

public class PartitaTest {
	Labirinto labirinto;
	Partita partita;
    @Before
    public void setUp() {
    	labirinto = new LabirintoBuilder().addStanzaIniziale("atrio").addStanzaVincente("laboratorio")
    			.addAdiacenza("atrio", "laboratorio", "sud").addAdiacenza( "laboratorio", "atrio","nord").getLabirinto();
    	partita = new Partita(labirinto);
    }


	@Test
	public void testGetStanzaVincente() {
		assertEquals("laboratorio", partita.getLabirinto().getStanzaFinale().getNome());
	}

	@Test
	public void testSetStanzaCorrente() {
		
		assertEquals("atrio", partita.getLabirinto().getStanzaCorrente().getNome());

	}

	@Test
	public void testIsFinita() {

		assertFalse(partita.isFinita());

		partita.getGiocatore().setCfu(0);
		assertEquals(true, partita.isFinita());

		partita.setFinita();
		assertEquals(true, partita.isFinita());
	}

}
