package it.polito.tdp.librettovoti.model;

import java.time.LocalDate;

//POJO -->Plain Old Java Object
//Java Bean
//Semplice contenitore di dati che non fa nulla
	//-->una calsse superipre gestirà dei dati

/**
 * Memorizza il risultato di un esame singolo
 * 
 * @author sofy9
 *
 */

public class Voto {

	private String nomeCorso;
	private int voto;
	private LocalDate dataEsame;
	
	/**
	 * 
	 * @param nomeCorso Nome corso superato
	 * @param voto Voto ottenuto
	 * @param dataEsame Data di superamento
	 */
	
	public Voto(String nomeCorso, int voto, LocalDate dataEsame) {
		this.nomeCorso = nomeCorso;
		this.voto = voto;
		this.dataEsame = dataEsame;
	}

	public String getNomeCorso() {
		return nomeCorso;
	}

	public void setNomeCorso(String nomeCorso) {
		this.nomeCorso = nomeCorso;
	}

	public int getVoto() {
		return voto;
	}

	public void setVoto(int voto) {
		this.voto = voto;
	}

	public LocalDate getDataEsame() {
		return dataEsame;
	}

	public void setDataEsame(LocalDate dataEsame) {
		this.dataEsame = dataEsame;
	}

	@Override
	public String toString() {
		return "Esame " + nomeCorso + " superato con " + voto + " il " + dataEsame ;
	}

	

}
