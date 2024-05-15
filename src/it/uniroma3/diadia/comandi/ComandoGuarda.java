package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoGuarda implements Comando {
IO io;
String nome;


public ComandoGuarda(IO io) {
	this.io=io;
	
	
	
	
}
	@Override
	public void esegui(Partita partita) {
		partita.getStanzaCorrente().getDescrizione(io);
		io.mostraMessaggio(partita.getGiocatore().getBorsa().toString());
		io.mostraMessaggio("Hai ancora: "+partita.getGiocatore().getCfu()+" CFU");
		

	}

	@Override
	public void setParametro(String parametro) {
		this.nome=parametro;

	}
	public String getParametro() {
		return "guarda";
	}
	public String getNome() {
		return this.nome;
	}

}
