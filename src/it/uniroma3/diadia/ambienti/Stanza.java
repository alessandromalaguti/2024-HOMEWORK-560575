package it.uniroma3.diadia.ambienti;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap; 
import java.util.List;
import java.util.Map;
import java.util.Set;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Classe Stanza - una stanza in un gioco di ruolo.
 * Una stanza e' un luogo fisico nel gioco.
 * E' collegata ad altre stanze attraverso delle uscite.
 * Ogni uscita e' associata ad una direzione.
 * 
 * @author docente di POO 
 * @see Attrezzo
 * @version base
*/

public class Stanza {
	
	static final private int NUMERO_MASSIMO_DIREZIONI = 4;
	static final protected int NUMERO_MASSIMO_ATTREZZI = 10;
	
	private String nome;
    private Map<String,Attrezzo> attrezzi;
    public Map<String,Stanza> stanzeAdiacenti;

    
    /**
     * Crea una stanza. Non ci sono stanze adiacenti, non ci sono attrezzi.
     * @param nome il nome della stanza
     */
    public Stanza(String nome) {
        this.nome = nome;
        this.stanzeAdiacenti = new HashMap<>();
        this.attrezzi = new HashMap<>();
    }

    /**
     * Imposta una stanza adiacente.
     *
     * @param direzione direzione in cui sara' posta la stanza adiacente.
     * @param stanza stanza adiacente nella direzione indicata dal primo parametro.
     */
    public void impostaStanzaAdiacente(String direzione, Stanza stanza) {
    	if(this.stanzeAdiacenti.size()<4)
       this.stanzeAdiacenti.put(direzione, stanza);
        	}
    

    /**
     * Restituisce la stanza adiacente nella direzione specificata
     * @param direzione
     */
	public Stanza getStanzaAdiacente(String direzione) {
		if(this.stanzeAdiacenti.get(direzione)!=null) {
			  
		        return this.stanzeAdiacenti.get(direzione);
		}
     return null;
	}

    /**
     * Restituisce la nome della stanza.
     * @return il nome della stanza
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Restituisce la descrizione della stanza.
     * @return la descrizione della stanza
     */
    public boolean getDescrizione(IO io) {
    	io.mostraMessaggio(this.toString());
    	return true;
    }

    /**
     * Restituisce la collezione di attrezzi presenti nella stanza.
     * @return la collezione di attrezzi nella stanza.
     */
    public List<Attrezzo> getAttrezzi() {
        return new ArrayList<>(this.attrezzi.values());
    }
    


    public void addAttrezzo(Attrezzo attrezzo) {
        this.attrezzi.put(attrezzo.getNome(),attrezzo);
    }

   /**
	* Restituisce una rappresentazione stringa di questa stanza,
	* stampadone la descrizione, le uscite e gli eventuali attrezzi contenuti
	* @return la rappresentazione stringa
	*/
    public String toString() {
    	StringBuilder risultato = new StringBuilder();
    	risultato.append(this.nome);
    	risultato.append("\nUscite: ");
    	risultato.append(" " + this.stanzeAdiacenti.keySet());
    	
    	
    	if(attrezzi.isEmpty())
    		risultato.append("\nstanza vuota");
    	else {
    		risultato.append("\nOggetti nella stanza: ");
    		risultato.append(" " + this.attrezzi.keySet());	
    		
    	}
    	
    	
    	
    	
    	
    	return risultato.toString().replace("[", "").replace("]", "");
    }

    /**
	* Controlla se un attrezzo esiste nella stanza (uguaglianza sul nome).
	* @return true se l'attrezzo esiste nella stanza, false altrimenti.
	*/
    public boolean hasAttrezzo(String nomeAttrezzo) {
		if (this.attrezzi.containsKey(nomeAttrezzo) && nomeAttrezzo!=null)
			return true;
		return false;
	}

	/**
     * Restituisce l'attrezzo nomeAttrezzo se presente nella stanza.
	 * @param nomeAttrezzo
	 * @return l'attrezzo presente nella stanza.
     * 		   null se l'attrezzo non e' presente.
	 */
    public Attrezzo getAttrezzo(String nomeAttrezzo) {
     if(nomeAttrezzo!=null)
    	 return this.attrezzi.get(nomeAttrezzo);
     return null;
	}


	/**
	 * Rimuove un attrezzo dalla stanza (ricerca in base al nome).
	 * @param nomeAttrezzo
	 * @return true se l'attrezzo e' stato rimosso, false altrimenti
	 */
	public boolean removeAttrezzo(Attrezzo attrezzo) {
		
	    return this.attrezzi.remove(attrezzo.getNome(),attrezzo);
	}



	public List<String> getDirezioni() {
		return new ArrayList<>(this.stanzeAdiacenti.keySet());
    }
	public int getNumeroStanzeAdiacenti() {
		return this.stanzeAdiacenti.size();
	}
	public Map<String,Stanza> getMapStanzeAdiacenti(){
		return this.stanzeAdiacenti;
	}
	
	public boolean isMagica() {
		
		if(this.getClass()== StanzaMagica.class)
			return true;
		return false;
	}


}