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
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;
import it.uniroma3.diadia.giocatore.Giocatore;


public class ComandoPosaTest {
	IO io=new IOConsole();
	Partita partita;
	Labirinto labirinto;
	ComandoPosa comando;
	Attrezzo attrezzo;
	
	Stanza Laboratorio;
	Giocatore giocatore;
	Borsa borsa;
	
	
	@Before
	public void setUp() {
		labirinto=new LabirintoBuilder().addStanzaIniziale("atrio").addStanzaVincente("laboratorio")
    			.addAdiacenza("atrio", "laboratorio", "sud").addAdiacenza( "laboratorio", "atrio","nord").getLabirinto();
		partita= new Partita(labirinto);
		comando = new ComandoPosa(io, "attrezzo");
		attrezzo= new Attrezzo("attrezzo", 1);
		Laboratorio= new Stanza("Laboratorio");
		giocatore = new Giocatore();
		borsa = new Borsa();
	}
	
	
	@Test
	public void ComandoPosaTest() {
		partita.setGiocatore(giocatore);
		giocatore.setBorsa(borsa);
		partita.setStanzaCorrente(Laboratorio);
		giocatore.getBorsa().addAttrezzo(attrezzo);
		comando.esegui(partita);
		assertTrue(Laboratorio.hasAttrezzo(attrezzo.getNome()));
		assertFalse(giocatore.getBorsa().hasAttrezzo(attrezzo.getNome()));
		
	}
	@Test
	public void ComandoPosaInesistenteTest() {
		partita.setGiocatore(giocatore);
		giocatore.setBorsa(borsa);
		partita.setStanzaCorrente(Laboratorio);
		Attrezzo attrezzoErrato= new Attrezzo("AttrezzoErrato", 1);
		giocatore.getBorsa().addAttrezzo(attrezzoErrato);
		comando.esegui(partita);
		
		assertFalse(Laboratorio.hasAttrezzo(attrezzoErrato.getNome()));
		
		assertTrue(giocatore.getBorsa().hasAttrezzo(attrezzoErrato.getNome()));
		
	}

}
