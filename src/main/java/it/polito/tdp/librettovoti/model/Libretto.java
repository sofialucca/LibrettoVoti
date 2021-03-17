package it.polito.tdp.librettovoti.model;

import java.util.*;

//si comporta da Modello

public class Libretto {

	private List<Voto> listaVoti;
	private Map<String,Voto> votiMap; //identity Map--> mappa per conservare identità oggetti
	
	public Libretto() {
		listaVoti=new ArrayList<>();
		votiMap=new HashMap<>();
		//System.out.println("Sono libretto e sono vivo."); //usato per controllare funzionamento
	}
	
	public void add(Voto voto) {
		listaVoti.add(voto);
		votiMap.put(voto.getNomeCorso(), voto);
	}
	
	/*
	public void stampaVotiUguali(int punteggio) {
		//libretto stampa da solo i voti
	}
	
	//più conveniente perchè generale e utilizzabile anche per interfaccia grafica
	public String votiUguali(int punteggio) {
		//calcola una stringa che contiene voti
		//sarà poi il chiamante a stamparli
		//Solo il nome?
		//tutto il voto.toString()?
	}
	 */
	
	public List<Voto> listaVotiUguali(int punteggio){
		//restituisce solo voti uguali a criterio
		//espone la forma dei dati, quindi "pericoloso" nel caso di modifiche successive
		List<Voto >risultato=new ArrayList<>();
		for(Voto v:this.listaVoti) {
			if(v.getVoto()==punteggio) {
				risultato.add(v);
			}
		}
		return risultato;
	}
	
	/**
	 * Verifica se nel libretto c'è già un voto con lo stesso esame e la stessa valutazione
	 * @param v
	 * @return
	 */
	public boolean esisteDuplicato(Voto v) {
//		boolean trovato=false;
//		for(Voto voto: this.listaVoti) {
//			if(voto.getNomeCorso().equals(v.getNomeCorso())&&voto.getVoto()==v.getVoto()) {
//				trovato=true;
//				break;
//			}
//		}
//		return trovato;
		
		Voto trovato=this.votiMap.get(v.getNomeCorso());
		if(trovato==null) {
			return false;
		}else if(trovato.getVoto()==v.getVoto()) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * Verifica se nel libretto c'è gia un esame con stesso nome ma voto diverso
	 * @param v
	 * @return
	 */
	public boolean esisteConflitto(Voto v) {
//		boolean trovato=false;
//		for(Voto voto: this.listaVoti) {
//			if(voto.getNomeCorso().equals(v.getNomeCorso())&&voto.getVoto()!=v.getVoto()) {
//				trovato=true;
//				break;
//			}
//		}
//		return trovato;
		
		Voto trovato=this.votiMap.get(v.getNomeCorso());
		if(trovato==null) {
			return false;
		}else if(trovato.getVoto()!=v.getVoto()) {
			return true;
		}else {
			return false;
		}
	}
	
	public Libretto votiUguali(int punteggio) {
		Libretto risultato=new Libretto();
		for(Voto v:this.listaVoti) {
			if(v.getVoto()==punteggio) {
				risultato.add(v);
			}
		}
		return risultato;
	}
	
	/**
	 * Ricerca del voto del corso di cui specificato il nome 
	 * Se il corso non esiste restituisce null
	 * @param nomeCorso
	 * @return
	 */
	
	public Voto ricercaCorso(String nomeCorso) {
//		Voto risultato=null;
//		for(Voto v:this.listaVoti) {
//			if(v.getNomeCorso().equals(nomeCorso)) {	//usare equals e non compareTo
//				risultato=v;
//				break;
//			}
//		}
//		return risultato;
		
		return this.votiMap.get(nomeCorso);
	}
	
	public String toString() {
		String s="";
		for(Voto v:this.listaVoti) {
			s+=v.toString()+"\n";
		}
		return s;
	}
}
