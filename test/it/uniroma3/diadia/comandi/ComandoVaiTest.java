package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVaiTest {
    IO io=new IOConsole();
	Partita partita= new Partita();
	ComandoVai comando = new ComandoVai(io, "sud");
	Stanza Laboratorio= new Stanza("Laboratorio");
	
	Stanza N11= new Stanza("N11");
	
	
	
	
	@Test
	public void DirezioneEsistenteTest() {
		Laboratorio.impostaStanzaAdiacente("sud", N11);
		partita.setStanzaCorrente(Laboratorio);
		comando.esegui(partita);
		assertEquals(N11,partita.getStanzaCorrente());
	}
	@Test
	public void DirezioneInesistenteTest() {
		Laboratorio.impostaStanzaAdiacente("nord", N11);
		partita.setStanzaCorrente(Laboratorio);
		comando.esegui(partita);
		assertEquals(Laboratorio,partita.getStanzaCorrente());
		
	}

}
