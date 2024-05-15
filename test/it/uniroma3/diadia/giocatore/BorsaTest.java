package it.uniroma3.diadia.giocatore;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.attrezzi.ComparatoreAttrezziPerPeso;
import it.uniroma3.diadia.giocatore.Borsa;

public class BorsaTest {

	Borsa borsa = new Borsa();
	Attrezzo cacciavite;
	Attrezzo martello;
	Attrezzo chiodo;
	
	@Before
	public void setUp() {
		cacciavite = new Attrezzo("cacciavite", 2);
		martello = new Attrezzo("martello", 16);
		chiodo= new Attrezzo("chiodo",5);
		borsa.addAttrezzo(cacciavite);
		borsa.addAttrezzo(chiodo);
	}

	@Test
	public void testAddAttrezzoPesoMinoreDiDieci() {
		assertTrue(borsa.addAttrezzo(cacciavite));

	}
	
	@Test
	public void testAddAttrezzoPesoMaggioreDiDieci() {
		assertFalse(borsa.addAttrezzo(martello));

	}
	
	@Test
	public void testGetPeso() {
		
		assertEquals(cacciavite, borsa.getAttrezzo("cacciavite"));

	}
	@Test
	public void testGetContenutoOrdinatoPerPeso() {
		
		List<Attrezzo> ordinata = borsa.getContenutoOrdinatoPerPeso();
		assertTrue(ordinata.get(0)==cacciavite);
		assertTrue(ordinata.get(1)==chiodo);
	}
	@Test
	public void testGetSortedSetOrdinataPerPeso() {
		SortedSet<Attrezzo> ordinato = borsa.getSortedSetOrdinatoPerPeso();
		assertTrue(ordinato.first()==cacciavite);
		
		
	}
	public void testGetMapOrdinataPerPeso() {
		
		Map<Integer,Set<Attrezzo>> ordinata = borsa.getContenutoRaggruppatoPerPeso();
		assertTrue(ordinata.get(2).contains(cacciavite));
		assertTrue(ordinata.get(5).contains(chiodo));
		
		
	}
}