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
		atrio = new Stanza("atrio");
		N11 = new Stanza("n11");
		labirinto =new LabirintoBuilder().addStanzaIniziale("atrio").addStanza(N11.getNome()).addStanzaVincente("laboratorio")
    			.addAdiacenza("atrio", "laboratorio", "sud").addAdiacenza( "laboratorio", "atrio","nord").getLabirinto();
		
		
	}


	@Test
	public void testGetStanzaVincente() {
		assertEquals("laboratorio", labirinto.getStanzaFinale().getNome());
	}


	@Test
	public void testSetStanzaCorrente() {
		labirinto.setStanzaCorrente(N11);
		assertEquals(N11, labirinto.getStanzaCorrente());
	}
	@Test
	public void testGetStanzaCorrente() {
		assertEquals("atrio", labirinto.getStanzaCorrente().getNome());
	}

}
