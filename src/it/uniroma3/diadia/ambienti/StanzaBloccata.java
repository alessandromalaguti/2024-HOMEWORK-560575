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
	if(direzioneBloccata.equals(dir) && !super.hasAttrezzo(attrezzoSblocco))
		
		return this;
	else
		return super.getStanzaAdiacente(dir);



	
}
@Override

public boolean getDescrizione(IO io) {
	super.getDescrizione(io);
	if(!super.hasAttrezzo(this.attrezzoSblocco)) {
		io.mostraMessaggio("La direzione " + this.direzioneBloccata + " é bloccata! Trova una chiave per aprirla");
		
	
	}
	
	
		
	return false;
}

	
	
	
	



}