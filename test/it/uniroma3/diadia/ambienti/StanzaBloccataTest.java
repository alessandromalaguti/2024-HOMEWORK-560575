package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccataTest {
	
	String direzioneBloccata= "sud";
	 Stanza stanzaBloccata= new StanzaBloccata("stanzaBloccata","chiave", direzioneBloccata);
	 Stanza stanzaAdiacente= new Stanza("stanzaAdiacente");
	 Attrezzo key= new Attrezzo("chiave",1);
	 
	IOConsole io = new IOConsole();
	
	
	@Test
	public void testDirezioneBloccataSenzaAttrezzo() {
		
		assertFalse(stanzaBloccata.getDescrizione(io));
	}
	@Test
	public void testGetDescrioneConAttrezzo() {
		
		stanzaBloccata.addAttrezzo(key);
		assertTrue(this.stanzaBloccata.getDescrizione(io));
	}
	@Test
	public void testGetStanzaAdiacenteSenzaAttrezzo() {
		stanzaBloccata.impostaStanzaAdiacente(direzioneBloccata, stanzaAdiacente);
		assertEquals(stanzaBloccata,stanzaBloccata.getStanzaAdiacente(direzioneBloccata));
	}
	@Test
	public void testGetStanzaAdiacenteConAttrezzo() {
		stanzaBloccata.addAttrezzo(key);
		stanzaBloccata.impostaStanzaAdiacente(direzioneBloccata, stanzaAdiacente);
		assertEquals(stanzaAdiacente,stanzaBloccata.getStanzaAdiacente(direzioneBloccata));
	}

}
