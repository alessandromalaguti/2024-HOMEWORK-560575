package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagicaTest {

	StanzaMagica stanzaMagica = new StanzaMagica("stanzaMagica");
	IOConsole io = new IOConsole();
	Attrezzo AttrezzoIncantato = new Attrezzo("Test", 2);

	@Test
	public void testStanzaMagicaNonAttivata() {
     stanzaMagica.addAttrezzo(AttrezzoIncantato);
     assertEquals(AttrezzoIncantato,stanzaMagica.getAttrezzo(AttrezzoIncantato.getNome()));
     
		
	}

	@Test
	public void testStanzaMagicaAttivata() {
		for(int i=0;i<3;i++) {
			 stanzaMagica.addAttrezzo(AttrezzoIncantato);
			 stanzaMagica.removeAttrezzo(AttrezzoIncantato);
			 System.out.println(i);
		}
		 stanzaMagica.addAttrezzo(AttrezzoIncantato);
	     
	     Attrezzo attrezzoVerifica= new Attrezzo("tseT",2);
	     assertTrue(stanzaMagica.hasAttrezzo(attrezzoVerifica.getNome()));
	     
	
	}

}
