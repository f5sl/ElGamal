/**
 * 
 */
package com.Utility;


import java.math.BigInteger;
import java.util.ArrayList;


/**
 * Classe che implementa algoritmi di ordinamento
 * @author Alessandro
 *
 */
public class AlgoritmoDiOrdinamento {
	
	/**
	 * Metodo statico che restituisce un array di BigInteger ordinato
	 * @param array L'array da ordinare
	 * @return L'array ordinato
	 */
	public static ArrayList<BigInteger> ordina(ArrayList<BigInteger> array){		
		
		//Ciclo su tutti gli elemnti dell'array
	    for(int i = 0; i < array.size()-1; i++) {
	        int minimo = i; 
	        for(int j = i+1; j < array.size(); j++) {
	
	        //Trovo il più piccolo
	            if(array.get(minimo).compareTo(array.get(j))>0) {
	                minimo = j;
	            }
	        }
	
	        //Scambio se l'indice del minimo è diverso dall'indice di partenza
	        if(minimo!=i) { 
	           	BigInteger k = array.get(minimo);
	            array.set(minimo, array.get(i));
	            array.set(i, k);
	        }
	    }
	    //Restituisco l'array
	    return array;
	}
	
	
	/**
	 * Metodo che restituisce un array ordinato senza duplicati
	 * @param array Array da ordinare e in cui togliere i duplicati
	 * @return Array ordinato senza duplicati
	 */
	public static ArrayList<BigInteger> ordinaSenzaDuplicati(ArrayList<BigInteger> array){
		//Ordino l'array
		array = ordina(array);
		//Rimuovo i duplicati
		for(int i = array.size()-1; i>0;i--){
			if(array.get(i).compareTo(array.get(i-1))==0){
				array.remove(i);
			}
		}
		//restituisco l'array		
		return array;
	}

}
