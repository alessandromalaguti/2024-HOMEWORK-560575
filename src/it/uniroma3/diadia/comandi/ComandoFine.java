package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoFine implements Comando {
IO io;

public ComandoFine(IO io) {
	this.io=io;
}

	@Override
	public void esegui(Partita partita) {
		io.mostraMessaggio("Grazie di aver giocato!");
	}

	@Override
	public void setParametro(String parametro) {
		

	}
	public String getParametro() {
		return "";
	}
	public String getNome() {
		return "fine";
	}

}
