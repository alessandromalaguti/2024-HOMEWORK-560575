package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBuia extends Stanza {

	private String AttrezzoLuce;

	public StanzaBuia(String nome, String Attrezzo) {
		super(nome);
		this.AttrezzoLuce = Attrezzo;

	}

	@Override
	public boolean getDescrizione(IO io) {
		boolean Luce = false;
		if (hasAttrezzo(AttrezzoLuce)) {
			super.getDescrizione(io);
			Luce = true;
		}
		super.getDescrizione(io);
		io.mostraMessaggio("Qui c'è un buio pesto...");
        return Luce;
	}
}
