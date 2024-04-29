package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi implements Comando {
private IO io;
private String nome;

public ComandoPrendi(IO io,String nomeAttrezzo) {
	this.io=io;
	this.nome=nomeAttrezzo;
}
	@Override
	public void esegui(Partita partita) {
		if (nome == null) {
			io.mostraMessaggio("Che attrezzo vuoi prendere dalla stanza?");
			nome = this.io.leggiRiga();
		}

		if (partita.getStanzaCorrente().hasAttrezzo(nome)) {
			Attrezzo attrezzoDaPrendere = partita.getStanzaCorrente().getAttrezzo(nome);

			partita.getGiocatore().getBorsa().addAttrezzo(attrezzoDaPrendere);
			partita.getStanzaCorrente().removeAttrezzo(attrezzoDaPrendere);

			io.mostraMessaggio("Attrezzo preso!");
		} else
			io.mostraMessaggio("L'attrezzo non è presente nella stanza");

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
		return "prendi";
	}


}
