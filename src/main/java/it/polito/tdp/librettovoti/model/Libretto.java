package it.polito.tdp.librettovoti.model;

import java.util.*;

public class Libretto {

	private List<Voto> listaVoti;
	
	public Libretto() {
		listaVoti=new ArrayList<>();
	}
	
	public void add(Voto voto) {
		listaVoti.add(voto);
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
		Voto risultato=null;
		for(Voto v:this.listaVoti) {
			if(v.getNomeCorso().equals(nomeCorso)) {	//usare equals e non compareTo
				risultato=v;
				break;
			}
		}
		return risultato;
	}
	
	public String toString() {
		String s="";
		for(Voto v:this.listaVoti) {
			s+=v.toString()+"\n";
		}
		return s;
	}
}
