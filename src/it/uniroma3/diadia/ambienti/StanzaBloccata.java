package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.IO;

public class StanzaBloccata extends Stanza {
	private String direzioneBloccata;
	private String attrezzoSblocco;
public StanzaBloccata(String nome, String Attrezzo, String direzione) {
	super(nome);
	this.attrezzoSblocco= Attrezzo;
	this.direzioneBloccata= direzione;
	
}


@Override
public Stanza getStanzaAdiacente(String dir) {
	if(dir==direzioneBloccata) {
		if(!super.hasAttrezzo(attrezzoSblocco))
			return this;
		return super.getStanzaAdiacente(dir);
	}
	
	return super.getStanzaAdiacente(dir);
	
}
@Override
public boolean getDescrizione(IO io) {
	
	if(!(super.hasAttrezzo(this.attrezzoSblocco))) {
		io.mostraMessaggio("Uscite:");
		for(int i=0; i< super.getNumeroStanzeAdiacenti();i++) {
			if(super.getDirezione(i)!=direzioneBloccata) {
				
				io.mostraMessaggio(getDirezione(i));
				
			}else {
				io.mostraMessaggio("La direzione " + this.direzioneBloccata + " è bloccata");
			}
		}
	}
	else {
		super.getDescrizione(io);
		return true;
	}
		
	return false;
}
}