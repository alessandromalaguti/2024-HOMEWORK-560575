package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Labirinto {
	
	private Stanza stanzaIniziale;
	private Stanza stanzaVincente;
	
	
	public Labirinto() {
	}
	

	
	public Stanza getStanzaCorrente() {
		return this.stanzaIniziale;
	}
	
	public void setStanzaCorrente(Stanza stanza) {
		this.stanzaIniziale = stanza;
	}

	public Stanza getStanzaFinale() {
		return this.stanzaVincente;
	}
	
	public void setStanzaFinale(Stanza stanza) {
		this.stanzaVincente = stanza;
	}
	
	public static LabirintoBuilder newBuilder() {
		return new LabirintoBuilder();
	}
}
