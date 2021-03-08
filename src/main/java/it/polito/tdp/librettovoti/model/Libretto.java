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
	
	public String toString() {
		String s="";
		for(Voto v:this.listaVoti) {
			s+=v.toString()+"\n";
		}
		return s;
	}
}
