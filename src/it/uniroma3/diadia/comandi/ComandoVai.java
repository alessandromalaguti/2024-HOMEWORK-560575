package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVai implements Comando {
	private String direzione;
	private IO io;

	public ComandoVai(IO io, String direzione) {
		this.io = io;
		this.direzione = direzione;
	}

	/**
	 * esecuzione del comando
	 */
	@Override
	public void esegui(Partita partita) {
		Stanza stanzaCorrente = partita.getStanzaCorrente();
		Stanza prossimaStanza = null;
		if (direzione == null) {
			this.io.mostraMessaggio("Dove vuoi andare? Specificare una direzione");
			return;
		}
		prossimaStanza = stanzaCorrente.getStanzaAdiacente(this.direzione);
		
		if (prossimaStanza ==null) {
			this.io.mostraMessaggio("Direzione Inesistente");
			return;
		}
		partita.setStanzaCorrente(prossimaStanza);
		io.mostraMessaggio(partita.getStanzaCorrente().getNome());
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu() - 1);

	}

	@Override
	public void setParametro(String parametro) {
		this.direzione = parametro;

	}

	public String getParametro() {
		return this.direzione;
	}

	public String getNome() {
		return "vai";
	}

}