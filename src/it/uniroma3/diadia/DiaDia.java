package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.FabbricaDiComandiFisarmonica;
import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author docente di POO (da un'idea di Michael Kolling and David J. Barnes)
 * 
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""
			+ "Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n"
			+ "Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"
			+ "I locali sono popolati da strani personaggi, " + "alcuni amici, altri... chissa!\n"
			+ "Ci sono attrezzi che potrebbero servirti nell'impresa:\n"
			+ "puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n"
			+ "o regalarli se pensi che possano ingraziarti qualcuno.\n\n"
			+ "Per conoscere le istruzioni usa il comando 'aiuto'.";

	private Partita partita;
	private IO io;

	public DiaDia(Labirinto labirinto, IO console) {
		this.io = console;
		this.partita = new Partita(labirinto);
		
	}
	public DiaDia(IO console) {
		this.io = console;
		Labirinto labirinto = new LabirintoBuilder().addStanzaIniziale("atrio").addStanzaVincente("laboratorio")
    			.addAdiacenza("atrio", "laboratorio", "sud").addAdiacenza( "laboratorio", "atrio","nord").getLabirinto();
	  this.partita= new Partita(labirinto);
	
	}

	public void gioca() {
		String istruzione;

		io.mostraMessaggio(MESSAGGIO_BENVENUTO);

		do {
			istruzione = io.leggiRiga();

		} while (!processaIstruzione(istruzione));
	}

	/**
	 * Processa una istruzione
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false
	 *         altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire;
		FabbricaDiComandiFisarmonica factory = new FabbricaDiComandiFisarmonica(io);
		comandoDaEseguire = factory.costruisciComando(istruzione);
		comandoDaEseguire.esegui(this.partita);
		if (this.partita.vinta())

			System.out.println("Hai vinto!");
		if (!this.partita.giocatoreIsVivo())

			System.out.println("Hai esaurito i CFU...");

		return this.partita.isFinita();
	}
	// implementazioni dei comandi dell'utente:

	/**
	 * Stampa informazioni di aiuto.
	 */

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra e ne stampa il
	 * nome, altrimenti stampa un messaggio di errore
	 */

	/**
	 * Comando "Fine".
	 */
	private void fine() {
		io.mostraMessaggio("Grazie di aver giocato!");
		; // si desidera smettere
	}

	public static void main(String[] argc) {
		IO io = new IOConsole();
		Labirinto labirinto = new LabirintoBuilder().addStanzaIniziale("atrio").addAttrezzo("lanterna", 2)
				.addStanza("laboratorio").addAttrezzo("chiave", 1).addAdiacenza("atrio", "laboratorio", "sud")
				.addAdiacenza("laboratorio", "atrio", "nord").addStanzaBuia("sottoscala", "lanterna")
				.addAdiacenza("laboratorio", "sottoscala", "ovest").addAdiacenza("sottoscala", "laboratorio", "est")
				.addStanza("cortile").addAdiacenza("laboratorio", "cortile", "est")
				.addAdiacenza("cortile", "laboratorio", "ovest").addStanzaMagica("LabIA", 3)
				.addAdiacenza("cortile", "LabIA", "sud").addAdiacenza("LabIA", "cortile", "nord")
				.addStanzaBloccata("presidenza", "chiave", "sud").addAdiacenza("laboratorio", "presidenza", "sud")
				.addAdiacenza("presidenza", "laboratorio", "nord").addStanza("corridoio").addAttrezzo("lente", 1)
				.addAdiacenza("corridoio", "sottoscala", "nord").addAdiacenza("sottoscala", "corridoio", "sud")
				.addAdiacenza("corridoio", "presidenza", "est").addAdiacenza("presidenza", "corridoio", "ovest")
				.addAdiacenza("LabIA", "presidenza", "ovest").addAdiacenza("presidenza", "LabIA", "est")
				.addStanzaVincente("aula magna").addAdiacenza("presidenza", "aula magna", "sud")
				.addAdiacenza("aula magna", "presidenza", "nord").getLabirinto();
		DiaDia gioco = new DiaDia(labirinto, io);
		gioco.gioca();
	}
}