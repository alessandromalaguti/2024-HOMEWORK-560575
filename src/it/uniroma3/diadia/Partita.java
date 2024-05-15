package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */

public class Partita {

	
	private boolean finita;
	private Giocatore giocatore;
	private Labirinto labirinto;
	
	public Partita(Labirinto labirinto){
		this.labirinto=labirinto;
		this.finita = false;
		giocatore = new Giocatore();
		
	}

    /**
     * Crea tutte le stanze e le porte di collegamento
     */
    


	public void setStanzaCorrente(Stanza stanzaCorrente) {
		
		labirinto.setStanzaCorrente(stanzaCorrente);
	}

	public Stanza getStanzaCorrente() {
		return labirinto.getStanzaCorrente();
	}
	

	public boolean giocatoreIsVivo() {
		if(this.giocatore.getCfu()>0)
			return true;
		return false;
	}
	
	public boolean vinta() {
		return this.getStanzaCorrente() == this.labirinto.getStanzaFinale();
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return finita || (giocatore.getCfu() == 0);
	}

	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}
	
	
	public Giocatore getGiocatore() {
		return giocatore;
	}

	public void setGiocatore(Giocatore giocatore) {
		this.giocatore = giocatore;
	}
	
	public void setLabirinto(Labirinto labirinto) {
		this.labirinto = labirinto;
	}
	
	public Labirinto getLabirinto() {
		return this.labirinto;
	}
}
