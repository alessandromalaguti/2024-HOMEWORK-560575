package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVaiTest {
    IO io=new IOConsole();
    Labirinto labirinto;
	Partita partita;
	ComandoVai comando;
	Stanza Laboratorio;
	
	Stanza N11;
	
	@Before
	public void setUp() {
		labirinto=new LabirintoBuilder().addStanzaIniziale("atrio").addStanzaVincente("laboratorio")
    			.addAdiacenza("atrio", "laboratorio", "sud").addAdiacenza( "laboratorio", "atrio","nord").getLabirinto();
		partita= new Partita(labirinto);
		comando = new ComandoVai(io, "sud");
		Laboratorio= new Stanza("Laboratorio");
		 N11= new Stanza("N11");
	
	}
	
	
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
