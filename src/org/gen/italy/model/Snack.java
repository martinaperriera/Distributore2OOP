package org.gen.italy.model;

public class Snack extends Prodotto {

	private int grammi; 
	
	//costruttore 
	public Snack(String nome, float costo, int quantita, int grammi) {
		super(nome, costo, quantita);
		this.grammi=grammi;
		
	}
//getter e setter
	public int getGrammi() {
		return grammi;
	}

	public void setGrammi(int grammi) {
		this.grammi = grammi;
	}
}
