package org.gen.italy;

import java.util.Scanner; 

import org.gen.italy.model.Prodotto;
import org.gen.italy.model.Bevanda;
import org.gen.italy.model.Snack;
import org.gen.italy.model.Distributore;


public class Main {

	public static void main(String[] args) {
		
		Distributore distributore = new Distributore();
        Scanner sc = new Scanner(System.in);
        int scelta = -1;
        
       do {
        	System.out.println(String.format("\nCredito attuale: %.2f", distributore.getCredito()));
            distributore.visualizzaProdotti();
            System.out.println("\nMenu:");
            System.out.println("1) Inserisci moneta");
            System.out.println("2) Eroga prodotto");
            System.out.println("3) Eroga resto");
            System.out.println("4) Esci");
            System.out.print("Scelta: ");
            scelta = sc.nextInt();
            
            switch (scelta) {
            case 1: 
            	System.out.print("Inserisci moneta: ");
            	double moneta= sc.nextDouble();
            	distributore.inserisciMoneta(moneta);
            	break;
            case 2: 
            	System.out.print("Inserisci numero prodotto: ");
            	int nrProdotto=sc.nextInt();
            	distributore.erogaProdotto(nrProdotto);
            	break; 
            case 3: 
            	distributore.erogaResto();
            	break;
            case 4: 
            	System.out.println("Alla prossima!!");
            	break;
            default:
            	System.out.println("Scelta non valida.");
            	
            	
            }
        } while (scelta !=4);
        sc.close();
	}
}
