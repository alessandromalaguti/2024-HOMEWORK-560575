package it.uniroma3.diadia.giocatore;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.attrezzi.ComparatoreAttrezziPerPeso;

public class Borsa {
	
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private Map<String, Attrezzo> attrezzi;
	private int pesoAttuale;
	private int pesoMax;
	
	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}
	
	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new HashMap<>(); 
		this.pesoAttuale = 0;
	}
	
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.getPesoAttuale() + attrezzo.getPeso() > this.getPesoMax())
			
			return false;
	   this.attrezzi.put(attrezzo.getNome(), attrezzo);
	   this.pesoAttuale+= attrezzo.getPeso();
	   return true;
	}
	
	public int getPesoMax() {
		return pesoMax;
	}
	public int getPesoAttuale() {
		return this.pesoAttuale;
	}
	
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		if(nomeAttrezzo == null)
			return null;
		return this.attrezzi.get(nomeAttrezzo);
		
		
	}
	public Map<String,Attrezzo> getAttrezzi(){
		return this.attrezzi;
	}

	



	
	public boolean isEmpty() {
		return this.pesoAttuale == 0;
	}
	
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}
	
	public boolean removeAttrezzo(String nomeAttrezzo) {
		
		if(nomeAttrezzo!=null) {
			this.pesoAttuale-=this.getAttrezzo(nomeAttrezzo).getPeso();
			attrezzi.remove(nomeAttrezzo);
			
			return true;
		}
		
		return false;
	}
	
	public String toString() {
		StringBuilder s = new StringBuilder();

		if (!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPesoAttuale()+"kg/"+this.getPesoMax()+"kg): ");
			List<Attrezzo> attrezzi=this.getContenutoOrdinatoPerPeso();
			s.append(attrezzi);
				
		}else
			s.append("Borsa vuota");
		
		return s.toString().replace("[", "").replace("]", "");
	}
	


	public SortedSet<Attrezzo> getContenutoOrdinatoPerNome() {
		
		return new TreeSet<Attrezzo>(this.attrezzi.values());
		
	}
	public List<Attrezzo> getContenutoOrdinatoPerPeso(){
		List<Attrezzo> ordinata = new ArrayList<>();
		ordinata.addAll(this.attrezzi.values());
		Collections.sort(ordinata, new ComparatoreAttrezziPerPeso());
		return ordinata;
	}
	
	public SortedSet<Attrezzo> getSortedSetOrdinatoPerPeso(){
		SortedSet<Attrezzo> ordinato = new TreeSet<Attrezzo>(new ComparatoreAttrezziPerPeso());
		ordinato.addAll(this.attrezzi.values());
		return ordinato;
	}
	
	public Map<Integer,Set<Attrezzo>> getContenutoRaggruppatoPerPeso(){
		Map<Integer,Set<Attrezzo>> ordinata = new TreeMap<>();
		for(Attrezzo a: this.attrezzi.values()) {
			if(ordinata.containsKey(a.getPeso())) {
				ordinata.get(a.getPeso()).add(a);
			}
			else {
				Set<Attrezzo> s = new HashSet();
				s.add(a);
				ordinata.put(a.getPeso(), s);
			}
		}
		
		return ordinata;
		
	}

}

