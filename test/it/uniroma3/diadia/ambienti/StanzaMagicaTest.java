package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagicaTest {

	Stanza stanzaMagica = new StanzaMagica("stanzaMagica");
	IOConsole io = new IOConsole();
	Attrezzo AttrezzoIncantato = new Attrezzo("Test", 2);

	@Test
	public void testStanzaMagicaNonAttivata() {
     stanzaMagica.addAttrezzo(AttrezzoIncantato);
     Attrezzo AttrezzoVerifica = new Attrezzo("Test",2);
     assertEquals(AttrezzoVerifica.getNome(),stanzaMagica.getAttrezzi()[0].getNome());
		
	}

	@Test
	public void testStanzaMagicaAttivata() {
		for(int i=0;i<3;i++) {
			 stanzaMagica.addAttrezzo(AttrezzoIncantato);
			 stanzaMagica.removeAttrezzo(AttrezzoIncantato);
			 System.out.println(i);
		}
	     Attrezzo AttrezzoVerifica = new Attrezzo("tseT",4);
	     stanzaMagica.addAttrezzo(AttrezzoIncantato);
	     assertEquals(AttrezzoVerifica.getNome(),stanzaMagica.getAttrezzi()[0].getNome());
	
	}

}
