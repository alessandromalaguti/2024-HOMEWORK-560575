package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoNonValido implements Comando {
IO io;


public ComandoNonValido(IO io) {
	this.io=io;
	
}
	@Override
	public void esegui(Partita partita) {
	this.io.mostraMessaggio("Il comando inserito non è valido");

	}

	@Override
	public void setParametro(String parametro) {
		

	}
	public String getParametro() {
		return "";
	}
	public String getNome() {
		return "";
	}

}
