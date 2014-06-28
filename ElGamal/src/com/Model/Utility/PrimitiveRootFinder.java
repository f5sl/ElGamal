/**
 * 
 */
package com.Model.Utility;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Classe che implementa un algoritmo per trovare una radice primitiva
 * 
 * @author Alessandro
 *
 */
public class PrimitiveRootFinder {
	
	public static BigInteger findPrimitiveRoot(BigInteger p){
		//NB 1 non è MAI radice primitiva, questo è un valore di default, necessario solo
		//ai fini dell'inizializzazione
		BigInteger radicePrimitiva = BigInteger.valueOf(1);
		
		
		Factorizator fattorizzatore = new Factorizator();
		
		ArrayList<BigInteger> fattoriPrimi = fattorizzatore.divisoriNumeroAvanzato(p.subtract(BigInteger.valueOf(1)));
		
		BigInteger maxOrdineDiP = fattoriPrimi.get(fattoriPrimi.size()-2);
		
		System.out.println("maxOrdine " + maxOrdineDiP);
	
		
		boolean scarta = false;
		
		boolean trovata =false;
		
		for(radicePrimitiva = BigInteger.valueOf(1); radicePrimitiva.compareTo(p)<=0 && trovata ==false;radicePrimitiva = radicePrimitiva.add(BigInteger.valueOf(1))){
			System.out.println("test sul numero "+ radicePrimitiva);
			scarta = false;	
			
			for(BigInteger i = BigInteger.valueOf(1); i.compareTo(maxOrdineDiP.add(BigInteger.valueOf(1)))<=0 && scarta == false && trovata == false; i = i.add(BigInteger.valueOf(1))){
				
				BigInteger risultatoPotenza = radicePrimitiva.modPow(i, p);
				
				System.out.println(risultatoPotenza);
					
					if(risultatoPotenza.equals(BigInteger.valueOf(1))){
						if(i.compareTo(maxOrdineDiP)<=0){
							scarta= true;
						}
						else{
							trovata = true;
						}
					}
				
			
			}
		
		}
			
		
		
		
		return radicePrimitiva;
	}

}
