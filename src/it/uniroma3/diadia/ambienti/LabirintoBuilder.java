package it.uniroma3.diadia.ambienti;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.uniroma3.diadia.attrezzi.Attrezzo;
 
public class LabirintoBuilder {
	Labirinto labirinto;
	Stanza ultimaStanzaAggiunta;
	Map<String, Stanza> stanze;

	public LabirintoBuilder() {
		labirinto = new Labirinto();
		stanze = new HashMap<>();
	}



	public LabirintoBuilder addStanzaIniziale(String stanza) {
		Stanza s = new Stanza(stanza);

		labirinto.setStanzaCorrente(s);

		

		return this.ultimaStanzaAggiorna(s);
	}

	public LabirintoBuilder addStanzaVincente(String stanza) {
		Stanza s = new Stanza(stanza);
		labirinto.setStanzaFinale(s);

		return this.ultimaStanzaAggiorna(s);

	}

	public LabirintoBuilder addStanza(String stanza) {
		Stanza s = new Stanza(stanza);
		
		
		this.ultimaStanzaAggiorna(s);
		return this;
	}
	public LabirintoBuilder addStanzaBuia(String stanza,String attrezzo) {
		Stanza s = new StanzaBuia(stanza,attrezzo);
		
		
		this.ultimaStanzaAggiorna(s);
		return this;
	}
	public LabirintoBuilder addStanzaBloccata(String stanza,String attrezzo,String direzione) {
		Stanza s = new StanzaBloccata(stanza,attrezzo,direzione);
		
		
		this.ultimaStanzaAggiorna(s);
		return this;
	}
	public LabirintoBuilder addStanzaMagica(String stanza,int soglia) {
		Stanza s = new StanzaMagica(stanza,soglia);
		
		
		this.ultimaStanzaAggiorna(s);
		return this;
	}
	public LabirintoBuilder ultimaStanzaAggiorna(Stanza s) {
		this.ultimaStanzaAggiunta=s;
		stanze.put(s.getNome(),s);
		
		
		return this;
	}

	public LabirintoBuilder addAdiacenza(String stanza1, String stanza2, String direzione) {

	Stanza c = stanze.get(stanza1);
	Stanza a = stanze.get(stanza2);
	
	c.impostaStanzaAdiacente(direzione, a);
	return this;
		
}
	
	public LabirintoBuilder addAttrezzo(String attrezzo,int peso) {
		if(attrezzo==null)
			return this;
		Attrezzo nuovoAttrezzo= new Attrezzo(attrezzo,peso);
		
		this.ultimaStanzaAggiunta.addAttrezzo(nuovoAttrezzo);
		
		return this;
	}
	
	
	public Labirinto getLabirinto() {
		return this.labirinto;
	}
	public Map<String,Stanza> getListaStanze(){
		return this.stanze;
	}
	
}
