package org.gen.italy.model;

public class Bevanda extends Prodotto {
 
	private boolean zuccherata; 
	
	//costruttore della superclasse utilizzato per inizializzare attributi
	public Bevanda(String nome, float costo, int quantita, boolean zuccherata) {
		super(nome, costo, quantita);
		this.zuccherata=zuccherata; 
	}

	//getter e setter
	public boolean isZuccherata() {
		return zuccherata;
	}

	public void setZuccherata(boolean zuccherata) {
		this.zuccherata = zuccherata;
	}
	
	
}

