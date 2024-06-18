package org.gen.italy.model;

public class Distributore {

	private double credito;
	private Prodotto [] elencoProdotti;
	
	public Distributore() {
		this.credito=0; //credito inizializzato a 0
		this.elencoProdotti=new Prodotto[6]; //array di prodotti
		elencoProdotti[0]= new Bevanda ("Fanta", 1.10f, 20, true);
		elencoProdotti[1]= new Bevanda ("Pepsi", 1.10f, 20, true);
		elencoProdotti[2]= new Bevanda ("The", 1.00f, 20, false);
        elencoProdotti[3] = new Snack("Patatine", 1.00f, 10, 100);
        elencoProdotti[4] = new Snack("Bounty", 1.30f, 5, 50);
        elencoProdotti[5] = new Snack("Crackers", 1.00f, 8, 30);	
	}

	public double getCredito() {
		return credito;
	}
	
	public void inserisciMoneta(double moneta) {
		if (moneta==0.10 || moneta==0.20 || moneta==0.50 || moneta==1 || moneta==2) {
			credito += moneta; //incrementa credito a seconda della moneta inserita
			System.out.println("Credito aggiornato: " + String.format("%.2f", credito));
		} else {
			System.out.println("Moneta non valida");
		}
	}
	public void erogaProdotto(int nrProdotto) {
		if (nrProdotto <0 || nrProdotto>=elencoProdotti.length) {
			System.out.println("Il prodotto non è valido");
			return;
			}
		//recupero prodotto dall'array in base al numero selezionato
		Prodotto prodotto = elencoProdotti[nrProdotto];
		if (prodotto.getQuantita()==0) {
			 System.out.println("Prodotto esaurito.");
	            return;
		}
		if (credito < prodotto.getCosto()) { //controllo credito
			System.out.println("Credito non sufficiente");
			return;
		}
		if (prodotto instanceof Bevanda) { //verifico il prodotto (tipo bevanda o snack?
			Bevanda bevanda = (Bevanda) prodotto; //se il prodotto è bevanda - casting
			String tipo = bevanda.isZuccherata()? "zuccherata":"non zuccherata";
			System.out.println("Bevanda " + bevanda.getNome() + " erogata correttamente - tipologia " + tipo);
		} else if (prodotto instanceof Snack) {
			Snack snack =(Snack) prodotto; 
			System.out.println("Snack " + snack.getNome() + " erogato correttamente - grammi " + snack.getGrammi());
		}
		credito -= prodotto.getCosto(); //costo prodotti sottratto dal credito disponibile
		System.out.println("Credito aggiornato: " + String.format("%.2f", credito));
		prodotto.setQuantita(prodotto.getQuantita() - 1); //quantità prodotto decrementata con il setteer 
	}
	//metodo visualizza prodotti
	public void visualizzaProdotti() {
		for (int i=0; i<elencoProdotti.length; i++) {
			Prodotto prodotto =elencoProdotti[i];
			if (prodotto instanceof Bevanda) {
				Bevanda bevanda = (Bevanda) prodotto;
				String tipo=bevanda.isZuccherata()? "zuccherata" : "non zuccherata";
                System.out.println("Prodotto " + (i+1) + ": Bevanda " + bevanda.getNome() + ", costo: " + bevanda.getCosto() + ", quantità: " + bevanda.getQuantita() + ", tipologia: " + tipo);

			} else if (prodotto instanceof Snack) {
				Snack snack = (Snack) prodotto;
                System.out.println("Prodotto " + (i+1) + ": Snack " + snack.getNome() + ", costo: " + snack.getCosto() + ", quantità: " + snack.getQuantita() + ", grammi: " + snack.getGrammi());
			}
		}
	}
	
	//metodo x resto
	public void erogaResto() {
        System.out.println("Resto erogato: " + String.format("%.2f", credito));
        credito = 0;
	}
}
