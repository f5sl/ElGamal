/**
 * 
 */
package com.Model.Utility;

import java.math.BigInteger;
import java.util.ArrayList;

/**
 * Classe che implementa un algoritmo per trovare una radice primitiva
 * 
 * @author Alessandro
 *
 */
public class PrimitiveRootFinder {
	/**
	 * Metodo che calcola una radice primitiva mod p
	 * @param p il primo generatore di un gruppo
	 * @return radice primitiva del gruppo
	 */
	public static BigInteger findPrimitiveRoot(BigInteger p){
		//NB 1 non è MAI radice primitiva, questo è un valore di default, necessario solo
		//ai fini dell'inizializzazione
		BigInteger radicePrimitiva = BigInteger.valueOf(1);
		
		//Recupero il fattorizzatore
		Factorizator fattorizzatore = new Factorizator();
		//Recupero la lista di divisori di p-1
		ArrayList<BigInteger> divisori = fattorizzatore.divisoriNumeroAvanzato(p.subtract(BigInteger.valueOf(1)));
		//Massimo ordine di p, escluso p-1
		BigInteger maxOrdineDiP = divisori.get(divisori.size()-2);
		//Variabili che identificano se la radice è scartata o se una è stata trovata
		
		boolean scarta = false;
		boolean trovata =false;
		//Ciclo su tutti i numeri invertibili mod p
		for(radicePrimitiva = BigInteger.valueOf(1); radicePrimitiva.compareTo(p)<0 && trovata == false ; radicePrimitiva = radicePrimitiva.add(BigInteger.valueOf(1))){
			//assegno scartata = false, perchè potrebbe essere diventata true per qualche valore		
			scarta = false;
			
			//Ciclo su tutti i possibili esponenti per calcolare tutte le potenze
			for(int i =0; i<divisori.size() && scarta == false && trovata == false ; i++){
				//Eseguo la potenza mod p
				BigInteger risultatoPotenza = radicePrimitiva.modPow(divisori.get(i), p);

				/* Verifico che il risultato della potenza sia 1 o meno. Se lo è devo vedere
				 * che l'esponente non sia <= del max ordine di p, eccetto p-1. In tal caso non 
				 * è una radice primitiva e va scartata. Altrimenti ho trovato la radice primitiva.		
				*/
				if(risultatoPotenza.compareTo(BigInteger.valueOf(1))==0){
					if(divisori.get(i).compareTo(maxOrdineDiP)<=0){
						scarta= true;
					}
					else{
						trovata = true;
					}
				}			
			}
			
		}
		//Restituisco il valore della radice primitiva, decrementato di 1 perchè, prima dell'uscita dal ciclo, il
		//suo valore risulta essere incrementato
		return radicePrimitiva.subtract(BigInteger.valueOf(1));
	}

}
