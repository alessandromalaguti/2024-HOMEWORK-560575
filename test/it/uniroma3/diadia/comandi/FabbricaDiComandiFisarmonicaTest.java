package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;

public class FabbricaDiComandiFisarmonicaTest {
  IO io= new IOConsole();
  FabbricaDiComandiFisarmonica factory = new FabbricaDiComandiFisarmonica(io);
	@Test
	public void testVai() {
		ComandoVai comando=new ComandoVai(io,"sud");
		assertEquals(comando.getParametro(),factory.costruisciComando("vai sud").getParametro());
		assertEquals(comando.getNome(),factory.costruisciComando("vai sud").getNome());
		
	}
	@Test
	public void testPrendi() {
		ComandoPrendi comando=new ComandoPrendi(io,"attrezzo");
		assertEquals(comando.getParametro(),factory.costruisciComando("prendi attrezzo").getParametro());
		assertEquals(comando.getNome(),factory.costruisciComando("prendi attrezzo").getNome());
		
	}
	@Test
	public void testPosa() {
		ComandoPosa comando=new ComandoPosa(io,"attrezzo");
		assertEquals(comando.getParametro(),factory.costruisciComando("posa attrezzo").getParametro());
		assertEquals(comando.getNome(),factory.costruisciComando("posa attrezzo").getNome());
		
	}
	public void testAiuto() {
		ComandoAiuto comando=new ComandoAiuto(io);
		assertEquals(comando.getParametro(),factory.costruisciComando("aiuto").getParametro());
		assertEquals(comando.getNome(),factory.costruisciComando("aiuto").getNome());
		
	}
	public void testFine() {
		ComandoFine comando=new ComandoFine(io);
		assertEquals(comando.getParametro(),factory.costruisciComando("fine").getParametro());
		assertEquals(comando.getNome(),factory.costruisciComando("fine").getNome());
		
	}
	public void testGuarda() {
		ComandoGuarda comando=new ComandoGuarda(io);
		assertEquals(comando.getParametro(),factory.costruisciComando("guarda").getParametro());
		assertEquals(comando.getNome(),factory.costruisciComando("guarda").getNome());
		
	}
	public void testNonvalido() {
		ComandoNonValido comando=new ComandoNonValido(io);
		assertEquals(comando.getParametro(),factory.costruisciComando("").getParametro());
		assertEquals(comando.getNome(),factory.costruisciComando("").getNome());
		
	}


}
