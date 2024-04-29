package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;
import it.uniroma3.diadia.giocatore.Giocatore;

public class ComandoPrendiTest {
	IO io=new IOConsole();
	Partita partita= new Partita();
	ComandoPrendi comando = new ComandoPrendi(io, "attrezzo");
	Attrezzo attrezzo= new Attrezzo("attrezzo", 1);
	
	Stanza Laboratorio= new Stanza("Laboratorio");
	Giocatore giocatore = new Giocatore();
	Borsa borsa = new Borsa();
	
	@Test
	public void ComandoPrendiTest() {
		partita.setGiocatore(giocatore);
		giocatore.setBorsa(borsa);
		partita.setStanzaCorrente(Laboratorio);
		Laboratorio.addAttrezzo(attrezzo);
		comando.esegui(partita);
		assertEquals(null,Laboratorio.getAttrezzi()[0]);
		assertTrue(giocatore.getBorsa().hasAttrezzo(attrezzo.getNome()));
		
	}
	public void ComandoPrendiInesistenteTest() {
		partita.setGiocatore(giocatore);
		giocatore.setBorsa(borsa);
		partita.setStanzaCorrente(Laboratorio);
		Attrezzo attrezzoErrato= new Attrezzo("AttrezzoErrato", 1);
		Laboratorio.addAttrezzo(attrezzoErrato);
		comando.esegui(partita);
		assertEquals(attrezzoErrato,Laboratorio.getAttrezzi()[0]);
		assertFalse(giocatore.getBorsa().hasAttrezzo(attrezzo.getNome()));
		
	}

}
