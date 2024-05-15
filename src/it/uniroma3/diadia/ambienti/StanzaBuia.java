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
		
		if (hasAttrezzo(AttrezzoLuce)) {
			super.getDescrizione(io);
			return true;
		}
		
		io.mostraMessaggio("Qui c'è un buio pesto...");
        return false;
	}
}
