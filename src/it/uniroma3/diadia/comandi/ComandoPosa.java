package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa implements Comando {
	IO io;
	String nome;
	
	public ComandoPosa(IO io,String nomeAttrezzo) {
		this.io=io;
		this.nome=nomeAttrezzo;
	}

	@Override
	public void esegui(Partita partita) {
		if (nome == null) {
			io.mostraMessaggio("Quale attrezzo vuoi posare nella stanza?");
			nome = this.io.leggiRiga();
		}

		if (partita.getGiocatore().getBorsa().hasAttrezzo(nome)) {
			Attrezzo attrezzoDaPosare = partita.getGiocatore().getBorsa().getAttrezzo(nome);

			partita.getStanzaCorrente().addAttrezzo(attrezzoDaPosare);
			partita.getGiocatore().getBorsa().removeAttrezzo(nome);

			io.mostraMessaggio("Attrezzo posato!");
		} else
			io.mostraMessaggio("L'attrezzo non è presente nella borsa");

	partita.getStanzaCorrente().getDescrizione(io);
		io.mostraMessaggio(partita.getGiocatore().getBorsa().toString());


	}

	@Override
	public void setParametro(String parametro) {
		this.nome=parametro;

	}
	public String getParametro() {
		return this.nome;
	}
	public String getNome() {
		return "posa";
	}


}
