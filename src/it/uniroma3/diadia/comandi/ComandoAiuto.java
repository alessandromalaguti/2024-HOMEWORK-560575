package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;

import it.uniroma3.diadia.Partita;

public class ComandoAiuto implements Comando {
  IO io;
  String nome;
  static final private String[] elencoComandi = { "vai", "aiuto", "fine", "prendi", "posa" };
	
  public ComandoAiuto(IO io) {
	  
	  this.io=io;
  }
	@Override
	public void esegui(Partita partita) {
		for (int i = 0; i < elencoComandi.length; i++)
			this.io.mostraMessaggio(elencoComandi[i] + " ");
		
		

	}

	@Override
	public void setParametro(String parametro) {
		this.nome=parametro;

	}
	public String getParametro() {
		return "aiuto";
		
	}
	public String getNome() {
		return "";
	}

}
