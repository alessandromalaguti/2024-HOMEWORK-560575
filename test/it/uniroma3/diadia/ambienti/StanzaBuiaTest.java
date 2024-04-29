package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.attrezzi.Attrezzo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class StanzaBuiaTest {

	 Stanza stanzaBuia= new StanzaBuia("stanzaBuia","Test");
	IOConsole io = new IOConsole();
	Attrezzo AttrezzoTest= new Attrezzo("Test",2);
	
	@Test
	public void testGetDescrioneSenzaAttrezzo() {
		
		assertFalse(this.stanzaBuia.getDescrizione(io));
	}
	@Test
	public void testGetDescrioneConAttrezzo() {
		
		stanzaBuia.addAttrezzo(AttrezzoTest);
		assertTrue(this.stanzaBuia.getDescrizione(io));
	}

}
