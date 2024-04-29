package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Labirinto {
	
	private Stanza stanzaIniziale;
	private Stanza stanzaFinale;
	
	public Labirinto() {
		creaStanze();
	}
	
	public void creaStanze() {
		/* crea gli attrezzi */
	    Attrezzo lanterna = new Attrezzo("lanterna",3);
		Attrezzo osso = new Attrezzo("osso",1);
		Attrezzo quaderno = new Attrezzo("quaderno",2);
		Attrezzo chiave = new Attrezzo("chiave",1);
	    	
			/* crea stanze del labirinto */
		Stanza atrio = new Stanza("Atrio");
		Stanza aulaN11 = new Stanza("Aula N11");
		Stanza aulaN10 = new Stanza("Aula N10");
		Stanza laboratorio = new Stanza("Laboratorio Campus");
		Stanza biblioteca = new Stanza("Biblioteca");
		Stanza LabIA = new StanzaMagica("LabIA");
		Stanza Sottoscala = new StanzaBuia("Sottoscala","lanterna");
		Stanza Presidenza = new StanzaBloccata("Presidenza","chiave","sud")	;
			/* collega le stanze */
		atrio.impostaStanzaAdiacente("nord", biblioteca);
		atrio.impostaStanzaAdiacente("est", aulaN11);
		atrio.impostaStanzaAdiacente("sud", aulaN10);
		atrio.impostaStanzaAdiacente("ovest", laboratorio);
		aulaN11.impostaStanzaAdiacente("est", laboratorio);
		aulaN11.impostaStanzaAdiacente("ovest", atrio);
		aulaN11.impostaStanzaAdiacente("nord", LabIA);
		aulaN11.impostaStanzaAdiacente("sud", Sottoscala);
		Sottoscala.impostaStanzaAdiacente("nord", aulaN11);
		aulaN10.impostaStanzaAdiacente("nord", atrio);
		aulaN10.impostaStanzaAdiacente("ovest", laboratorio);
		aulaN10.impostaStanzaAdiacente("sud", Presidenza);
		Presidenza.impostaStanzaAdiacente("nord", aulaN10);
		Presidenza.impostaStanzaAdiacente("sud", laboratorio);
		laboratorio.impostaStanzaAdiacente("est", atrio);
		laboratorio.impostaStanzaAdiacente("nord", aulaN11);
		laboratorio.impostaStanzaAdiacente("ovest", Presidenza);
		biblioteca.impostaStanzaAdiacente("sud", atrio);
		biblioteca.impostaStanzaAdiacente("est", LabIA);
		LabIA.impostaStanzaAdiacente("ovest", laboratorio);

	        /* pone gli attrezzi nelle stanze */
		aulaN11.addAttrezzo(lanterna);
		atrio.addAttrezzo(osso);
		LabIA.addAttrezzo(quaderno);
		aulaN10.addAttrezzo(chiave);


			// il gioco comincia nell'atrio
	    this.stanzaIniziale = atrio;  
		this.stanzaFinale = biblioteca;
	}
	
	public Stanza getStanzaIniziale() {
		return this.stanzaIniziale;
	}
	
	public void setStanzaIniziale(Stanza stanza) {
		this.stanzaIniziale = stanza;
	}

	public Stanza getStanzaFinale() {
		return this.stanzaFinale;
	}
	
	public void setStanzaFinale(Stanza stanza) {
		this.stanzaFinale = stanza;
	}
}
