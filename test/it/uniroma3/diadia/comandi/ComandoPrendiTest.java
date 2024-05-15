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

public class ComandoPrendiTest {
	IO io=new IOConsole();
	Labirinto labirinto;
	Partita partita;
	ComandoPrendi comando;
	Attrezzo attrezzo;
	 Stanza Laboratorio;
	Giocatore giocatore;
	Borsa borsa;
	
	
	@Before
	public void setUp() {
		labirinto=new LabirintoBuilder().addStanzaIniziale("atrio").addStanzaVincente("laboratorio")
    			.addAdiacenza("atrio", "laboratorio", "sud").addAdiacenza( "laboratorio", "atrio","nord").getLabirinto();
		partita= new Partita(labirinto);
		comando = new ComandoPrendi(io, "attrezzo");
		attrezzo= new Attrezzo("attrezzo", 1);
		Laboratorio= new Stanza("Laboratorio");
		 giocatore = new Giocatore();
		 borsa = new Borsa();
	}
	
	
	
	@Test
	public void ComandoPrendiTest() {
		partita.setGiocatore(giocatore);
		giocatore.setBorsa(borsa);
		partita.setStanzaCorrente(Laboratorio);
		Laboratorio.addAttrezzo(attrezzo);
		comando.esegui(partita);
		assertFalse(Laboratorio.hasAttrezzo(attrezzo.getNome()));
		assertTrue(giocatore.getBorsa().hasAttrezzo(attrezzo.getNome()));
		
	}
	public void ComandoPrendiInesistenteTest() {
		partita.setGiocatore(giocatore);
		giocatore.setBorsa(borsa);
		partita.setStanzaCorrente(Laboratorio);
		Attrezzo attrezzoErrato= new Attrezzo("AttrezzoErrato", 1);
		Laboratorio.addAttrezzo(attrezzoErrato);
		comando.esegui(partita);
		assertFalse(Laboratorio.hasAttrezzo(attrezzo.getNome()));
		assertFalse(giocatore.getBorsa().hasAttrezzo(attrezzo.getNome()));
		
	}

}
